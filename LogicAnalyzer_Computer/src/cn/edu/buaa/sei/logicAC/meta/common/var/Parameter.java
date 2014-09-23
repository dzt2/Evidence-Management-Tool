package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface Parameter extends Variable{
	public static enum ParameterType {IN,OUT,INOUT};
	
	public ParameterType getParameterType();
	public void setParameterType(ParameterType type);
}
