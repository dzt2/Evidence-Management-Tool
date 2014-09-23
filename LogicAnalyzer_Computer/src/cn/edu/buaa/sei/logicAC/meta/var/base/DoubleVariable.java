package cn.edu.buaa.sei.logicAC.meta.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface DoubleVariable extends TypedVariable{
	public Double read() throws Exception;
	public void assign(Double val) throws Exception;
}
