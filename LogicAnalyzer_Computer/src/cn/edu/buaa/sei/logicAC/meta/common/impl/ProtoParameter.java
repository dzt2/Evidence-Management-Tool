package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.Parameter;

/**
 * ProtoParameter: prototype of parameter, which is also a variable
 * */
public abstract class ProtoParameter extends VariableImpl implements Parameter{
	ParameterType type=ParameterType.IN;

	protected ProtoParameter(String name) throws Exception {super(name);}

	@Override
	public ParameterType getType() {return this.type;}

	@Override
	public void setType(ParameterType type) {this.type=type;}

}
