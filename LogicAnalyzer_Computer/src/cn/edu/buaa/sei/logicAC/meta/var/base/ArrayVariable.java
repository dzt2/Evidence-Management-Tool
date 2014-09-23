package cn.edu.buaa.sei.logicAC.meta.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface ArrayVariable extends TypedVariable{
	public Object[] read() throws Exception;
	public void assign(Object[] val) throws Exception;
}
