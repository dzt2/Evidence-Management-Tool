package cn.edu.buaa.sei.emt.core;

public class CoreFactory {
	
	
	
	public static TaggedValue createTaggedValue() {
		return new TaggedValueImpl();
	}
	
	public static Annotation createAnnotation() {
		return new AnnotationImpl();
	}
	
}
