package cn.edu.buaa.exLmf.metamodel;

public interface LClassObject extends LObject{
	public LClass getType();
	
	public LObject get(LStructuralFeature feature);
	public void set(LStructuralFeature feature, LObject value);
	public Boolean isSet(LStructuralFeature feature);
	public void unSet(LStructuralFeature feature);
}
