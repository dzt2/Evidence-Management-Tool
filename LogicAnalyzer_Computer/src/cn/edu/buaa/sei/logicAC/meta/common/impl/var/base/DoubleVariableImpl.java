package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.DoubleVariable;

public class DoubleVariableImpl extends TypedVariableImpl implements DoubleVariable{

	protected DoubleVariableImpl(String name) throws Exception {super(name, Double.class);}

	@Override
	public void assign(Double val) throws Exception {super.assign(val);}
	@Override
	public Double read() throws Exception{return (Double) super.read();}
	

}
