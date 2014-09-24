package cn.edu.buaa.sei.logicAC.meta.common.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface BooleanVariable extends TypedVariable{
	public Boolean read() throws Exception;
	public void assign(Boolean val) throws Exception;
}
