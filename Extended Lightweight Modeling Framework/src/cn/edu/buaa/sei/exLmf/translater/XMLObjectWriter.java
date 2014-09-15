package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;
import cn.edu.buaa.sei.exLmf.metamodel.LAttribute;
import cn.edu.buaa.sei.exLmf.metamodel.LClassObject;
import cn.edu.buaa.sei.exLmf.metamodel.LDataObject;
import cn.edu.buaa.sei.exLmf.metamodel.LDataType;
import cn.edu.buaa.sei.exLmf.metamodel.LEnum;
import cn.edu.buaa.sei.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.sei.exLmf.metamodel.LObject;
import cn.edu.buaa.sei.exLmf.metamodel.LReference;
import cn.edu.buaa.sei.exLmf.metamodel.impl.LMFException;
import cn.edu.buaa.sei.exLmf.metamodel.impl.LPrimitiveTypeImpl;

public class XMLObjectWriter implements IObjectWriter{
	
	public static String ROOT = "OSpace";
	public static String _ID = "_id";
	public static String TRUE = "true";
	public static String FALSE = "false";
	public static String NULL = "null";
	public static String LIST = "__list";
	public static String ITEM = "__item";
	public static String NAME = "name";
	
	File file;
	String name;
	IObjectSpace os;
	
	public XMLObjectWriter(String name){this.name=name;}
	/*Tool Functions*/
	Exception getException(String func,String arg,String reason){
		return LMFException.create("XML-Object-Writer "+this.name, "LMFCreator", func, arg, reason);
	}
	
	
	@Override
	public void setResource(File file) {this.file=file;}
	@Override
	public void setObjectSpace(IObjectSpace os) {this.os=os;}

	@Override
	public boolean validate() {
		if(this.file==null||this.os==null)return false;
		return true;
	}

	@Override
	public void translate() throws Exception {
		if(!this.validate())return;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
			
		Element root = document.createElement(ROOT);
		document.appendChild(root);
			
		Collection<LClassObject> objs = this.os.getAllObjects();
		for(LClassObject obj:objs){
			Element elm = this.translateClassObject(obj, document);
			if(elm!=null)root.appendChild(elm);
		}
			
		// Write File
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        PrintWriter pw = new PrintWriter(new FileOutputStream(this.file));
        StreamResult result = new StreamResult(pw);
        transformer.transform(source, result);
        
	}
	
	Element translateClassObject(LClassObject obj,Document doc) throws Exception{
		if(obj==null||doc==null||!this.os.containObject(obj))return null;
		Element ans = doc.createElement(obj.type().getName());
		ans.setAttribute(_ID, this.os.getIDof(obj).toString());
		
		List<LAttribute> attributes = obj.getType().getAllAttributes();
		List<LReference> references = obj.getType().getAllReferences();
		
		for(int i=0;i<attributes.size();i++){
			LAttribute attribute = attributes.get(i);			
			Element attr_elm = null;
			if(attribute.getUpperBound()>1||attribute.getUpperBound()==LMultipleObject.UNBOUNDED)
				attr_elm = this.translateAttributes(attribute, (LMultipleObject) obj.get(attribute), doc);
			else
				attr_elm = this.translateAttribute(attribute, (LDataObject) obj.get(attribute), doc);
			
			if(attr_elm!=null)ans.appendChild(attr_elm);
		}
		for(int i=0;i<references.size();i++){
			LReference reference = references.get(i);
			Element ref_elm = null;
			if(reference.getUpperBound()>1||reference.getUpperBound()==LMultipleObject.UNBOUNDED)
				ref_elm = this.translateReferences(reference, (LMultipleObject) obj.get(reference), doc);
			else
				ref_elm = this.translateReference(reference, (LClassObject) obj.get(reference), doc);
			
			if(ref_elm!=null)ans.appendChild(ref_elm);
		}
		
		return ans;
	}
	
	Element translateAttribute(LAttribute attribute,LDataObject val,Document doc) throws Exception{
		if(attribute==null||doc==null)return null;
		Element ans = doc.createElement(attribute.getName());
		
		LDataType atype = attribute.getDataType();
		
		if(atype==LPrimitiveTypeImpl.BOOL){
			if(val.boolVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else if(val.boolVal())ans.appendChild(doc.createTextNode(TRUE));
			else ans.appendChild(doc.createTextNode(FALSE));
		}
		else if(atype==LPrimitiveTypeImpl.INT){
			if(val.integerVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else ans.appendChild(doc.createTextNode(val.integerVal().toString()));
		}
		else if(atype==LPrimitiveTypeImpl.LONG){
			if(val.longVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else ans.appendChild(doc.createTextNode(val.longVal().toString()));
		}
		else if(atype==LPrimitiveTypeImpl.FLOAT){
			if(val.floatVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else ans.appendChild(doc.createTextNode(val.floatVal().toString()));
		}
		else if(atype==LPrimitiveTypeImpl.DOUBLE){
			if(val.doubleVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else ans.appendChild(doc.createTextNode(val.doubleVal().toString()));
		}
		else if(atype==LPrimitiveTypeImpl.STRING){
			if(val.stringVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else ans.appendChild(doc.createTextNode(val.stringVal()));
		}
		else if(atype instanceof LEnum){
			if(val.literalVal()==null)ans.appendChild(doc.createTextNode(NULL));
			else ans.appendChild(doc.createTextNode(val.literalVal().getName()));
		}
		else{
			throw this.getException("translateAttribute(attribute,val,doc)", 
					"attribute.type", "Attribute \""+attribute.getName()+"\"'s type \""+atype.getName()+"\" is unknown.");
		}
		
		return ans;
	}
	Element translateReference(LReference reference,LClassObject val,Document doc){
		if(reference==null||val==null||doc==null||!this.os.containObject(val))return null;
		Element ans = doc.createElement(reference.getName());
		ans.appendChild(doc.createTextNode(this.os.getIDof(val).toString()));
		return ans;
	}
	
	Element translateAttributes(LAttribute attribute,LMultipleObject mval,Document doc) throws Exception{
		if(attribute==null||mval==null||doc==null)return null;
		Element elm = doc.createElement(LIST);
		elm.setAttribute(NAME, attribute.getName());
		
		LDataType atype = attribute.getDataType();
		Collection<LObject> list = mval.getAllObjects();
		
		for(LObject obj:list){
			LDataObject val = (LDataObject) obj;
			Element ans = doc.createElement(ITEM);
			
			if(atype==LPrimitiveTypeImpl.BOOL){
				if(val.boolVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else if(val.boolVal())ans.appendChild(doc.createTextNode(TRUE));
				else ans.appendChild(doc.createTextNode(FALSE));
			}
			else if(atype==LPrimitiveTypeImpl.INT){
				if(val.integerVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else ans.appendChild(doc.createTextNode(val.integerVal().toString()));
			}
			else if(atype==LPrimitiveTypeImpl.LONG){
				if(val.longVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else ans.appendChild(doc.createTextNode(val.longVal().toString()));
			}
			else if(atype==LPrimitiveTypeImpl.FLOAT){
				if(val.floatVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else ans.appendChild(doc.createTextNode(val.floatVal().toString()));
			}
			else if(atype==LPrimitiveTypeImpl.DOUBLE){
				if(val.doubleVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else ans.appendChild(doc.createTextNode(val.doubleVal().toString()));
			}
			else if(atype==LPrimitiveTypeImpl.STRING){
				if(val.stringVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else ans.appendChild(doc.createTextNode(val.stringVal()));
			}
			else if(atype instanceof LEnum){
				if(val.literalVal()==null)ans.appendChild(doc.createTextNode(NULL));
				else ans.appendChild(doc.createTextNode(val.literalVal().getName()));
			}
			else{
				throw this.getException("translateAttribute(attribute,val,doc)", 
						"attribute.type", "Attribute \""+attribute.getName()+"\"'s type \""+atype.getName()+"\" is unknown.");
			}
			
			elm.appendChild(ans);
		}
		return elm;
	}
	Element translateReferences(LReference reference,LMultipleObject mval,Document doc){
		if(reference==null||mval==null||doc==null)return null;
		Element elm = doc.createElement(LIST);
		elm.setAttribute(NAME, reference.getName());
		
		Collection<LObject> list = mval.getAllObjects();
		
		for(LObject obj:list){
			LClassObject val = (LClassObject) obj;
			
			if(this.os.containObject(val)){
				Element ans = doc.createElement(ITEM);
				ans.appendChild(doc.createTextNode(this.os.getIDof(val).toString()));
				elm.appendChild(ans);
			}
		}
		
		return elm;
	}
}
