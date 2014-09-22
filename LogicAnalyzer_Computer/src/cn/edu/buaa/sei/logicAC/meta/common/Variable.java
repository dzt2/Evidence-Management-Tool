package cn.edu.buaa.sei.logicAC.meta.common;

public interface Variable {
	public String getName();
	public void assign(Object val) throws Exception;
	public Object read() throws Exception;
}
