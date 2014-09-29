package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.common.LogicFunctionImpl;

public class PredicateFunctionImpl extends LogicFunctionImpl implements PredicateFunction{

	protected PredicateFunctionImpl(LogicFunctionTemplate template,
			PredicateFunctionEnvironment env) throws Exception {
		super(template, env);
	}

	@Override
	public void setEnvironment(PredicateFunctionEnvironment env)
			throws Exception {
		if(env==null)
			throw new Exception("Null environment is null invalid");
		this.env=env;
	}
	
	@Override
	public void setEnvironment(RunnerEnvironment env)
			throws Exception {
		if(env==null)
			throw new Exception("Null environment is null invalid");
		if(!(env instanceof PredicateFunctionEnvironment))
			throw new ClassCastException("Invalid environment type: "+env.getClass().getName());
		this.env=env;
	}
	
	public PredicateFunctionEnvironment getEnvironment(){return (PredicateFunctionEnvironment) this.env;}

}
