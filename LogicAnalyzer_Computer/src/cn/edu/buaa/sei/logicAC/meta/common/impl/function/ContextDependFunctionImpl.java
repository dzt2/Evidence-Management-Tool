package cn.edu.buaa.sei.logicAC.meta.common.impl.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.function.ContextDependFunction;
import cn.edu.buaa.sei.logicAC.meta.common.function.FunctionTemplate;

public abstract class ContextDependFunctionImpl extends FunctionImpl implements ContextDependFunction{
	
	RunnerEnvironment context=null;
	
	protected ContextDependFunctionImpl(FunctionTemplate template,RunnerEnvironment context) throws Exception {
		super(template);
		this.setContext(context);
	}

	@Override
	public void setContext(Context context) throws Exception {
		if(context==null)
			throw new Exception("Null context is invalid in the context-depend function");
		if(!(context instanceof RunnerEnvironment))
			throw new Exception("Context should ba a RunnerEnvironment");
		if(this.context==context)return;
		
		context.addComputableUnit(this);
	}

	@Override
	public void setContext(RunnerEnvironment context) throws Exception {
		if(context==null)
			throw new Exception("Null context is invalid in the context-depend function");
		if(this.context==context)return;
		
		context.addComputableUnit(this);
	}

	@Override
	public RunnerEnvironment getContext() {return this.context;}

}
