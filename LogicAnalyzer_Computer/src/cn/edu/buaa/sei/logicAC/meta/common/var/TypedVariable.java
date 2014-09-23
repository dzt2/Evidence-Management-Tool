package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface TypedVariable extends Variable{
	public Class<?> getType();
	public void setType(Class<?> type);
}
