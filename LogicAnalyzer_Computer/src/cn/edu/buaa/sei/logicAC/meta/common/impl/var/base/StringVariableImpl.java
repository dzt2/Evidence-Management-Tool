package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.StringVariable;

public class StringVariableImpl extends TypedVariableImpl implements StringVariable{

	protected StringVariableImpl(String name) throws Exception {super(name, String.class);}
	@Override
	public void assign(String val) throws Exception {super.assign(val);}
	@Override
	public String read() throws Exception{return (String) super.read();}
	
}
