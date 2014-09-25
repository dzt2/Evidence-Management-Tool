package cn.edu.buaa.sei.logicAC.meta.common.impl.function;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextFreeFunction;
import cn.edu.buaa.sei.logicAC.meta.common.function.FunctionTemplate;

public abstract class ContextFreeFunctionImpl extends FunctionImpl implements ContextFreeFunction{

	protected ContextFreeFunctionImpl(FunctionTemplate template) throws Exception {super(template);}

}
