package cn.edu.buaa.sei.logicAC.meta.var.base;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface SetVariable extends TypedVariable{
	public Set<?> read() throws Exception;
	public void assign(Set<?> val) throws Exception;
}
