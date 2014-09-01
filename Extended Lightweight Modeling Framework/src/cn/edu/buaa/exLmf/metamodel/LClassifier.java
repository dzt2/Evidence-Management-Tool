package cn.edu.buaa.exLmf.metamodel;

public interface LClassifier extends LNamedElement{
	public int getClassifierID();
	public void setClassifierID(int id);
	public String getInstanceName();
	public void setInstanceName(String ins);
	public LObject getDefaultValue();
	public LObject setDefaultValue(LObject val);
}
