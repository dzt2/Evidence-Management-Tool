package cn.edu.buaa.exLmf.metamodel;

public interface LAttribute extends LStructuralFeature{
	public LDataType getDataType();
	public void setDataType(LDataType type);
	public Boolean isID();
	public void setID(Boolean isID);
}
