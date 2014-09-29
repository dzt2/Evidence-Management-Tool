package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;

public abstract class LogicFunctionImpl extends LogicFormulationImpl implements LogicFunction{
	protected RunnerEnvironment env;
	protected LogicFunctionTemplate template;
	
	protected LogicFunctionImpl(LogicFunctionTemplate template,RunnerEnvironment env) throws Exception{
		if(template==null||env==null)
			throw new Exception("Template|Env is null invalid");
		
		this.template=template; this.env=env;
	}

	@Override
	public RunnerEnvironment getEnvironment() {return this.env;}

	@Override
	public void setEnvironment(RunnerEnvironment env) throws Exception {
		if(env==null)
			throw new Exception("Null Environment is invalid");
		this.env=env;
	}

	@Override
	public LogicFunctionTemplate getTemplate() {return this.template;}

}
