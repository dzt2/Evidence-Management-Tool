package cn.edu.buaa.sei.logicAC.meta.common;

public interface Bindable extends Computable{
	public Object read() throws Exception;;
	public void assign(Object val) throws Exception;;
}
