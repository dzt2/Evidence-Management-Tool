package cn.edu.buaa.sei.exLmf.metamodel;

public interface LStructuralFeature extends LTypedElement{
	public LClassifier getContainer();
	public void setContainer(LClassifier type);
	public Boolean isChangable();
	public void setChangable(boolean changable);
	public int getFeatureID();	/*Local Identification*/
	public LObject getDefaultValue();
	public void setDefaultValue(LObject value);
}
