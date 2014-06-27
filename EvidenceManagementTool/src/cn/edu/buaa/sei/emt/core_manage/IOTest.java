package cn.edu.buaa.sei.emt.core_manage;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.sei.emt.core.CoreTypeLoader;
import cn.edu.buaa.sei.emt.core.Element;
import cn.edu.buaa.sei.emt.logic.Conjunction;
import cn.edu.buaa.sei.emt.logic.LogicFactory;
import cn.edu.buaa.sei.emt.logic.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.LogicTypeLoader;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.lmf.Type;

public class IOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LMFContext.load(new CoreTypeLoader());
		LMFContext.load(new LogicTypeLoader());
		LMFContext.pack();
		
		//Set<Element> elements = getTestedElements();
		
		Set<Element> elements = getMongo();
		
		/*Set<Element> elements = getTestedPropositions();
		ModelElementIO rs = new ModelElementIO();
		rs.configMongo("test_logic");;
		rs.write(elements);
		
		System.out.println("Complete!");*/
		System.out.println(elements.size());
		for(Element elm:elements){
			Type t = elm.type();
			System.out.println(t.getFullName());
		}
	}
	
	public static Set<Element> getTestedElements(){
		/*ModelElement e1 = CoreFactory.createModelElement(); e1.setId("e1");
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
		
		return elements;*/
		return null;
	}

	
	public static Set<Element> getTestedPropositions(){
		Set<Element> elements = new HashSet<Element>();
		
		LogicFormulation a = LogicFactory.createPropositionVariable();
		a.setName("A");
		a.setId("a1");
		elements.add(a);
		
		LogicFormulation b = LogicFactory.createPropositionVariable();
		b.setName("B");
		b.setId("b1");
		elements.add(b);
		
		Conjunction c = LogicFactory.createConjunction();
		c.setName("AND");
		c.setId("&1");
		
		c.getOperators().add(a); c.getOperators().add(b);
		elements.add(c);
		
		return elements;
	}
	
	
	public static Set<Element> getXML(){
		ModelElementIO rs = new ModelElementIO();
		rs.configXML(new File("test.xml"));
		Set<Element> elements = rs.read();
		
		return elements;
	}
	
	public static Set<Element> getMongo(){
		ModelElementIO rs = new ModelElementIO();
		rs.configMongo("test_logic");;
		Set<Element> elements = rs.read();
		
		return elements;
	}

	
}
