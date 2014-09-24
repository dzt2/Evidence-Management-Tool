package cn.edu.buaa.sei.logicAC.meta.common.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface StringVariable extends TypedVariable{
	public String read() throws Exception;
	public void assign(String val) throws Exception;
}
