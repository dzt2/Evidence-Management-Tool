package test;

import cn.edu.buaa.sei.lmf.LMFContext;
import core.Annotation;
import core.CoreFactory;
import core.CoreTypeLoader;
import core.ModelElement;
import core.TaggedValue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LMFContext.load(new CoreTypeLoader());
		LMFContext.pack();
		
		ModelElement elm = CoreFactory.createModelElement();
		elm.setId("1");
		elm.setGid("01");
		
		Annotation a1 = CoreFactory.createAnnotation();
		a1.setContent("This is a model element with id = \"1\"!!!");
		
		elm.getAnnotations().add(a1);
		
		TaggedValue tag = CoreFactory.createTaggedValue();
		tag.setKey("GID");
		tag.setValue("01");
		elm.getTags().add(tag);
		
		tag = CoreFactory.createTaggedValue();
		tag.setKey("ID");
		tag.setValue("1");
		elm.getTags().add(tag);
		
		printElement(elm);
		
	}
	
	public static void printElement(ModelElement elm){
		System.out.println("ID: "+elm.getId());
		System.out.println("GID: "+elm.getGid());
		System.out.print("Tags: {");
		for(int i=0;i<elm.getTags().size();i++){
			TaggedValue tag = elm.getTags().get(i);
			System.out.print(tag.getKey()+": "+tag.getValue());
			if(i!=elm.getTags().size()-1)System.out.print("; ");
		}
		System.out.print("}\n");
		System.out.print("Annotation: [");
		for(int i=0;i<elm.getAnnotations().size();i++){
			Annotation notation = elm.getAnnotations().get(i);
			System.out.print(notation.getContent());
			if(i!=elm.getAnnotations().size()-1)System.out.print(", ");
		}
		System.out.println("]");
	}

}
