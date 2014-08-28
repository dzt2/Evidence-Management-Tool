package cn.edu.buaa.exLmf.metamodel;

public interface LFactory extends LModelElement{
	public LPackage getContainer();
	
	public LObject create(LClass type);
	public LObject create(LDataType type,String code);
}
