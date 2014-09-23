package cn.edu.buaa.sei.logicAC.meta.var.base;

import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface ListVariable extends TypedVariable{
	public List<?> read() throws Exception;
	public void assign(List<?> val) throws Exception;
}
