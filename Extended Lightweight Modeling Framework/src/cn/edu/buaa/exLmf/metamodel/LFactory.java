package cn.edu.buaa.exLmf.metamodel;

public interface LFactory extends LModelElement{
	public LPackage getContainer();
	public LClassObject create(LClass type);
	public LDataObject create(LDataType type,String code);
}
