package cn.edu.buaa.sei.logicAC.meta.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface LongVariable extends TypedVariable{
	public Long read() throws Exception;
	public void assign(Long val) throws Exception;
}
