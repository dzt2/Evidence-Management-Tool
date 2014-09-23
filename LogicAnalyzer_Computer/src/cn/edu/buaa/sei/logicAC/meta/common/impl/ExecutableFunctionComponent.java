package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.ExecutableContext;
import cn.edu.buaa.sei.logicAC.meta.common.ExecutableFunction;

public abstract class ExecutableFunctionComponent extends GeneralFunctionComponent implements ExecutableFunction{
	ExecutableContext context;

	protected ExecutableFunctionComponent(String name,ExecutableContext context) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
		if(context==null)throw new Exception("Null context is invalid to construct executable function");
		this.context=context;
	}

	@Override
	public void setContext(ExecutableContext context) {
		if(context!=null)
			this.context=context;
	}

}
