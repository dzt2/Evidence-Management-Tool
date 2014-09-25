package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.FloatVariable;

public class FloatVariableImpl extends TypedVariableImpl implements FloatVariable{

	protected FloatVariableImpl(String name) throws Exception {super(name, Float.class);}

	@Override
	public void assign(Float val) throws Exception {super.assign(val);}
	@Override
	public Float read() throws Exception{return (Float) super.read();}
}
