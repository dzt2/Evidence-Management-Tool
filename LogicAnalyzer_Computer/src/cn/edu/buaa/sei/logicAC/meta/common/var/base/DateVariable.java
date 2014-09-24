package cn.edu.buaa.sei.logicAC.meta.common.var.base;

import java.util.Date;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface DateVariable extends TypedVariable{
	public Date read() throws Exception;
	public void assign(Date val) throws Exception;
}
