package cn.edu.buaa.exLmf.metamodel;

public interface LClassifier extends LNamedElement{
	public int getClassifierID();
	public void setClassifierID(int id);
	public String getInstanceName();
	public LObject getDefaultValue();
}
