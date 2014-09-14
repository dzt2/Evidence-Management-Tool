package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;
import cn.edu.buaa.sei.exLmf.manager.impl.ObjectSpace;
import cn.edu.buaa.sei.exLmf.metamodel.LAttribute;
import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LClassObject;
import cn.edu.buaa.sei.exLmf.metamodel.LDataObject;
import cn.edu.buaa.sei.exLmf.metamodel.LDataType;
import cn.edu.buaa.sei.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;
import cn.edu.buaa.sei.exLmf.metamodel.LReference;
import cn.edu.buaa.sei.exLmf.metamodel.LStructuralFeature;
import cn.edu.buaa.sei.exLmf.metamodel.impl.LMFException;

public class XMLObjectImporter implements IObjectImporter{
	LPackage p;
	File file;
	String name;
	Map<Integer,Integer> tmap = new HashMap<Integer,Integer>();
	IObjectSpace os;
	
	public XMLObjectImporter(String name){this.name=name;}
	/*Tool Functions*/
	Exception getException(String func,String arg,String reason){
		return LMFException.create("XML-Object-Importer "+this.name, "LMFCreator", func, arg, reason);
	}

	@Override
	public void setModel(LPackage p) {this.p=p;}
	@Override
	public void setResource(File file) {this.file=file;}

	@Override
	public boolean validate() {
		if(this.file==null||this.p==null)
			return false;
		return true;
	}
	@Override
	public IObjectSpace translate() throws Exception {
		if(!this.validate())return null;
		
		if(this.os!=null)this.os.clearSpace();
		os = new ObjectSpace("",this.p);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		
		NodeList rlist = document.getChildNodes();
		Element root = (Element) rlist.item(0);
		
		NodeList list = root.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			if(!(list.item(i) instanceof Element))continue;
			Element objElm = (Element) list.item(i);
			
			LClass ctype = (LClass) this.p.getClassifierByName(objElm.getTagName());
			if(ctype==null)
				throw this.getException("translate()","root.elements["+i+"]", "Unknown Tag: \""+objElm.getTagName()+"\"");
			
			Integer id = Integer.parseInt(objElm.getAttribute(IObjectWriter._ID));
			if(this.tmap.containsKey(id))
				throw this.getException("translate()","root.elements["+i+"].id", "Conflict ID: \""+id+"\"");
			
			LClassObject obj = os.createClassObject(ctype);
			Integer tid = os.getIDof(obj);
			this.tmap.put(id, tid);
			
		}
		
		for(int i=0;i<list.getLength();i++){
			if(!(list.item(i) instanceof Element))continue;
			Element objElm = (Element) list.item(i);
			
			Integer id = Integer.parseInt(objElm.getAttribute(IObjectWriter._ID));
			if(!this.tmap.containsKey(id))
				throw this.getException("translate()","root.elements["+i+"].id", "Undefined ID: \""+id+"\"");
			Integer tid = this.tmap.get(id);
			
			LClassObject obj = (LClassObject) this.os.getObject(tid);
			this.interprete(objElm, obj);
		}
		
		return os;
	}
	
	void interprete(Element objElm,LClassObject obj) throws Exception{
		if(objElm==null||obj==null)return;
		
		LClass ctype = obj.getType();
		NodeList featureNodes = objElm.getChildNodes();
		for(int i=0;i<featureNodes.getLength();i++){
			if(!(featureNodes.item(i) instanceof Element))continue;
			Element fnode = (Element) featureNodes.item(i);
			LStructuralFeature feature = ctype.getFeatureByName(fnode.getTagName());
			
			if(feature instanceof LAttribute){
				if(feature.getUpperBound()>1||feature.getUpperBound()==LMultipleObject.UNBOUNDED){
					LMultipleObject list =  (LMultipleObject) obj.get(feature);
					this.interpreteAttributes(fnode, (LAttribute)feature,list);
				}
				else{
					obj.set(feature, this.interpreteAttribute(fnode, (LAttribute) feature));
				}
			}
			else if(feature instanceof LReference){
				if(feature.getUpperBound()>1||feature.getUpperBound()==LMultipleObject.UNBOUNDED){
					LMultipleObject list =  (LMultipleObject) obj.get(feature);
					this.interpreteReferences(fnode, (LReference)feature, list);
				}
				else{
					obj.set(feature, this.interpreteReference(fnode, (LReference) feature));
				}
			}
		}
	}
	LDataObject interpreteAttribute(Element fnode,LAttribute attribute) throws Exception{
		if(fnode==null||attribute==null)return null;
		
		LDataType atype = attribute.getDataType();
		String text = fnode.getTextContent();
		return this.os.createDataObject(atype, text);
	}
	void interpreteAttributes(Element fnode,LAttribute attribute,LMultipleObject list){
		if(fnode==null||attribute==null||list==null)return;
		
		LDataType atype = attribute.getDataType();
		NodeList items = fnode.getElementsByTagName(IObjectWriter.ITEM);
		for(int i=0;i<items.getLength();i++){
			Element itemNode = (Element) items.item(i);
			String text = itemNode.getTextContent();
			list.addObject(this.os.createDataObject(atype, text));
		}
	}
	
	LClassObject interpreteReference(Element fnode,LReference ref) throws Exception{
		if(fnode==null||ref==null)return null;
		
		Integer id = Integer.parseInt(fnode.getTextContent());
		if(!this.tmap.containsKey(id))
			throw this.getException("interpreteReference(fnode,ref)", "fnode.id", "Unknown ID: \""+id+"\"");
		Integer tid = this.tmap.get(id);
		
		return (LClassObject) this.os.getObject(tid);
	}
	void interpreteReferences(Element fnode,LReference ref,LMultipleObject list) throws Exception{
		if(fnode==null||ref==null||list==null)return;
		
		NodeList items = fnode.getElementsByTagName(IObjectWriter.ITEM);
		for(int i=0;i<items.getLength();i++){
			Element itemNode = (Element) items.item(i);
			Integer id = Integer.parseInt(itemNode.getTextContent());
			if(!this.tmap.containsKey(id))
				throw this.getException("interpreteReference(fnode,ref)", "fnode.id", "Unknown ID: \""+id+"\"");
			Integer tid = this.tmap.get(id);
			
			list.addObject(this.os.getObject(tid));
		}
	}

}
