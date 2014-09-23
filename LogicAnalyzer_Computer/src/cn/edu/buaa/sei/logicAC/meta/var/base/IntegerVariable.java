package cn.edu.buaa.sei.logicAC.meta.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface IntegerVariable extends TypedVariable{
	public Integer read() throws Exception;
	public void assign(Integer val) throws Exception;
}
