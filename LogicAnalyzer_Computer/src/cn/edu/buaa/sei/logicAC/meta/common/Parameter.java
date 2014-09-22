package cn.edu.buaa.sei.logicAC.meta.common;

public interface Parameter extends Variable{
	public ParameterType getType();
	public void setType(ParameterType type);
	
	public static enum ParameterType {IN,OUT,INOUT};
}
