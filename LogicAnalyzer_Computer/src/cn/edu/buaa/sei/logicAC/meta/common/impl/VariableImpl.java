package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.Variable;

public abstract class VariableImpl extends BindableImpl implements Variable{
	String name;
	
	protected VariableImpl(String name) throws Exception{
		super();
		if(name==null)throw new Exception("creating variable with Null name");
		this.name=name;
	}
	
	@Override
	public String getName() {return this.name;}
}
