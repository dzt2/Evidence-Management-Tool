package cn.edu.buaa.sei.logicAC.meta.common;

public interface TypedVariable extends Variable{
	public Class<?> getType();
	public boolean compatible(Object object);
}
