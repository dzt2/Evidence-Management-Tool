package cn.edu.buaa.sei.emt.core_manage;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.sei.emt.core.CoreFactory;
import cn.edu.buaa.sei.emt.core.CoreTypeLoader;
import cn.edu.buaa.sei.emt.core.Element;
import cn.edu.buaa.sei.emt.core.ModelElement;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.lmf.LMFContext;

public class IOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LMFContext.load(new CoreTypeLoader());
		LMFContext.pack();
		
		//Set<Element> elements = getTestedElements();
		
		Set<Element> elements = getXML();
		
		System.out.println(elements.size());
	}
	
	public static Set<Element> getTestedElements(){
		ModelElement e1 = CoreFactory.createModelElement(); e1.setId("e1");
		ModelElement e2 = CoreFactory.createModelElement(); e2.setId("e2");
		ModelElement e3 = CoreFactory.createModelElement(); e3.setId("e3");
		ModelElement e4 = CoreFactory.createModelElement(); e4.setId("e4");
		
		TaggedValue tag;
		
		tag = CoreFactory.createTaggedValue();
		tag.setKey("ID"); tag.setValue("Element One");
		e1.getTags().add(tag);
		
		tag = CoreFactory.createTaggedValue();
		tag.setKey("ID"); tag.setValue("Element One By One");
		e1.getTags().add(tag);
		
		tag = CoreFactory.createTaggedValue();
		tag.setKey("ID"); tag.setValue("Element Second");
		e2.getTags().add(tag);
		
		tag = CoreFactory.createTaggedValue();
		tag.setKey("GID"); tag.setValue("Element 0003");
		e3.getTags().add(tag);
		
		e4.setGid("0004x");
		
		Set<Element> elements = new HashSet<Element>();
		elements.add(e1);
		elements.add(e2);
		elements.add(e3);
		elements.add(e4);
		
		return elements;
	}
	
	public static Set<Element> getXML(){
		ModelElementIO rs = new ModelElementIO();
		rs.configXML(new File("test.xml"));
		Set<Element> elements = rs.read();
		
		return elements;
	}

	
}
