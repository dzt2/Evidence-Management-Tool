package cn.edu.buaa.exLmf.metamodel;

public interface LObject extends LModelElement{
	public LClassifier type();
	public LObject get(LStructuralFeature feature);
	public void set(LStructuralFeature feature, LObject value);
	
	public Boolean isSet(LStructuralFeature feature);
	public void unSet(LStructuralFeature feature);
}
