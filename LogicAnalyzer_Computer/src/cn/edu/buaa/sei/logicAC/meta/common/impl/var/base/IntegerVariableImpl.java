package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.IntegerVariable;

public class IntegerVariableImpl extends TypedVariableImpl implements IntegerVariable{

	protected IntegerVariableImpl(String name) throws Exception {super(name, Integer.class);}

	@Override
	public void assign(Integer val) throws Exception {super.assign(val);}
	@Override
	public Integer read() throws Exception{return (Integer) super.read();}
}
