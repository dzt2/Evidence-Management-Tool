package cn.edu.buaa.sei.SVI.core.variable.impl;

import cn.edu.buaa.sei.SVI.core.variable.FreeVariable;

public class FreeVariableImpl extends VariableImpl implements FreeVariable{

	protected FreeVariableImpl(String name) {super(name);}
	@Override
	public void assign(Object val) throws Exception {this.val=val;}
}
