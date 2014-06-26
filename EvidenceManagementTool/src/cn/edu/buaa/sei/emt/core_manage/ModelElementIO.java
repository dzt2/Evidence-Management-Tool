package cn.edu.buaa.sei.emt.core_manage;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.sei.emt.core.CoreFactory;
import cn.edu.buaa.sei.emt.core.Element;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.lmf.ManagedObject;
import cn.edu.buaa.sei.lmf.manage.ISpace;
import cn.edu.buaa.sei.lmf.manage.ISpaceFileResource;
import cn.edu.buaa.sei.lmf.manage.ISpaceImpl;
import cn.edu.buaa.sei.lmf.manage.ISpaceMongoResource;
import cn.edu.buaa.sei.lmf.manage.ISpaceResource;
import cn.edu.buaa.sei.lmf.manage.ISpaceXMLResource;

public class ModelElementIO {
	Element e0 = CoreFactory.createElement();
	
	ISpace ispace = new ISpaceImpl();
	ISpaceResource resource;
	Set<Element> elements;
	
	public ModelElementIO(){
	}
	
	public void configFile(File file){
		this.resource = new ISpaceFileResource(file);
	}
	public void configXML(File file){
		this.resource = new ISpaceXMLResource(file);
	}
	public void configMongo(String collection){
		this.resource = new ISpaceMongoResource(collection);
	}
	
	public Set<Element> read(){
		this.resource.setReadable();
		this.ispace = this.resource.get();
		Set<ManagedObject> set = this.ispace.getInstancesFromType(LMFContext.typeForName(Element.TYPE_NAME));
		Set<Element> elements = new HashSet<Element>();
		for(ManagedObject obj:set)
			elements.add((Element) obj);
		return elements;
	}
	
	public void write(Set<Element> elements){
		if(elements==null)return;
		this.ispace = new ISpaceImpl();
		for(Element elm:elements){
			this.ispace.loadInstance(elm);
		}
		this.resource.setWritable();
		this.resource.put(ispace);
	}
	
	public void add(Set<Element> elements){
		if(elements==null)return;
		this.ispace = new ISpaceImpl();
		for(Element elm:elements){
			this.ispace.loadInstance(elm);
		}
		this.resource.setAppendable();
		this.resource.add(ispace);
	}
	
}
