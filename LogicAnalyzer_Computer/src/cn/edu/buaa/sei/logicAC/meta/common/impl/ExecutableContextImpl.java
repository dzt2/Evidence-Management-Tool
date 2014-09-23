package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.ExecutableContext;
import cn.edu.buaa.sei.logicAC.meta.common.VariablePool;

public class ExecutableContextImpl extends PackagedVariablePool implements ExecutableContext{
	public ExecutableContextImpl(VariablePool pool) throws Exception {super(pool);}
}
