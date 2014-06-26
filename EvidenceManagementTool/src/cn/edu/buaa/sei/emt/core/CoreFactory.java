package cn.edu.buaa.sei.emt.core;

public class CoreFactory {
	
	
	
	public static Element createElement() {
		return new ElementImpl();
	}
	
	public static ModelElement createModelElement() {
		return new ModelElementImpl();
	}
	
	public static UtilityElement createUtilityElement() {
		return new UtilityElementImpl();
	}
	
	public static TaggedValue createTaggedValue() {
		return new TaggedValueImpl();
	}
	
	public static Annotation createAnnotation() {
		return new AnnotationImpl();
	}
	
}
