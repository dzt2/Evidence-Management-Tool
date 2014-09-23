package cn.edu.buaa.sei.logicAC.meta.var.base;

import java.util.Map;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface MapVariable extends TypedVariable{
	public Map<?,?> read() throws Exception;
	public void assign(Map<?,?> val) throws Exception;
}
