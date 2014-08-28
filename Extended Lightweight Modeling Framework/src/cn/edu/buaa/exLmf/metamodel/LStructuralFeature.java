package cn.edu.buaa.exLmf.metamodel;

public interface LStructuralFeature extends LTypedElement{
	public LClassifier getContainingType();
	public Boolean isChangable();
	public void setChangable(Boolean changable);
	public int getFeatureID();
	public void setFeatureID(int id);
	public LObject getDefaultValue();
	public void setDefaultValue(LObject value);
}
