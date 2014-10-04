package cn.edu.buaa.sei.logicAC.meta.common.var.base;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface SetVariable extends TypedVariable{
	public Set<Object> read() throws Exception;
	public void assign(Set<Object> val) throws Exception;
}
