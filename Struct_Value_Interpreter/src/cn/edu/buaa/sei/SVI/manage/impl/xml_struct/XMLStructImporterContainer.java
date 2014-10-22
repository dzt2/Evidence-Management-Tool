package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class XMLStructImporterContainer {
	public Map<String,Element> def_map = new HashMap<String,Element>();
	public Map<Element,String> ref_map = new HashMap<Element,String>();
	public Map<String,Struct> result_map = new HashMap<String,Struct>();
	public Map<Element,Struct> cache = new HashMap<Element,Struct>();
	
	public XMLVariableReader vi = new XMLVariableReader(this);
	public XMLExpressionReader ei = new XMLExpressionReader(this);
	public XMLFunctionReader fi = new XMLFunctionReader(this);
	
	public static XMLStructImporterContainer container;
	
	protected XMLStructImporterContainer(Element root) throws Exception{
		if(root==null)throw new Exception("Null root is invalid");
		
		Queue<Element> queue = new LinkedList<Element>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Element e = queue.poll();
			this.addElement(e);
			
			NodeList children = e.getChildNodes();
			for(int i=0;i<children.getLength();i++)
				if(children.item(i) instanceof Element){
					queue.add((Element) children.item(i));
				}
		}
		
		Iterator<Element> itor = this.ref_map.keySet().iterator();
		while(itor.hasNext()){
			Element ei = itor.next();
			String ref = this.ref_map.get(ei);
			if(!this.def_map.containsKey(ref))
				throw new Exception("Undefined Refer ID: "+ref+" at <"+ei.getTagName()+">");
		}
	}
	
	void addElement(Element element) throws Exception{
		if(element==null)throw new Exception("Null element is invalid");
		
		String id = element.getAttribute(XMLStructTags.ID);
		if(id!=null&&id.length()>0){
			if(this.def_map.containsKey(id))throw new Exception("Conflict ID: "+id+" at <"+element.getTagName()+">");
			this.def_map.put(id, element);
		}
		else{
			String ref = element.getAttribute(XMLStructTags.REF);
			if(ref!=null&&ref.length()>0){
				this.ref_map.put(element, ref);
			}
		}
	}
	
	public Struct getResult(Element element) throws Exception{
		if(element==null)throw new Exception("Null element is invalid");
		if(!this.cache.containsKey(element))
			throw new Exception("Result has not been produced: "+element.getTagName());
		return this.cache.get(element);
	}
	public void setResult(Element element,Struct result) throws Exception{
		if(element==null||result==null)throw new Exception("Null element|result is invalid");
		
		if(this.cache.containsKey(element))throw new Exception("Duplication Interpretation at: <"+element.getTagName()+">");
		
		this.cache.put(element, result);
		
		String id = element.getAttribute(XMLStructTags.ID);
		if(id==null||id.length()==0)return;
		
		if(this.result_map.containsKey(id))throw new Exception("Duplicated ID Produced: "+id);
		this.result_map.put(id, result);
	}
	public boolean containResult(Element element){
		if(element==null)return false;
		else return this.cache.containsKey(element);
	}
	
	public Map<String,Element> getDefinedElementMap(){return this.def_map;}
	public Map<Element,String> getReferedElementMap(){return this.ref_map;}
	public Map<String,Struct> getResults(){return this.result_map;}
	public Map<Element,Struct> getCache(){return this.cache;}
	
	public Element getOriginalElement(Element elm) throws Exception{
		if(elm==null)throw new Exception("Null element is invalid");
		
		if(this.ref_map.containsKey(elm))
			return this.def_map.get(this.ref_map.get(elm));
		else return elm;
	}
	
	public XMLInterpreter getInterpreter(Element element) throws Exception{
		if(element==null)throw new Exception("Null element is invalid");
		
		String tag = element.getTagName();
		if(tag.equals(XMLStructTags.VARIABLE))return vi;
		else if(tag.equals(XMLStructTags.FUNCTION))return fi;
		else if(tag.equals(XMLStructTags.EXPRESSION))return ei;
		else if(tag.equals(XMLStructTags.FILTER))return fi;
		else if(tag.equals(XMLStructTags.MAPPER))return fi;
		else if(tag.equals(XMLStructTags.TABLE_MAPPER))return fi;
		else throw new Exception("Unknown Element Tag: <"+tag+">");
	}
}
