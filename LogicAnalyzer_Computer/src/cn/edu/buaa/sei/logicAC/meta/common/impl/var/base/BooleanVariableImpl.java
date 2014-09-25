package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.BooleanVariable;

public class BooleanVariableImpl extends TypedVariableImpl implements BooleanVariable{

	protected BooleanVariableImpl(String name) throws Exception {super(name, Boolean.class);}

	@Override
	public void assign(Boolean val) throws Exception {super.assign(val);}
	public Boolean read() throws Exception{return (Boolean) super.read();}

}
