package cn.edu.buaa.sei.logicAC.meta.common.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface FloatVariable extends TypedVariable{
	public Float read() throws Exception;
	public void assign(Float val) throws Exception;
}
