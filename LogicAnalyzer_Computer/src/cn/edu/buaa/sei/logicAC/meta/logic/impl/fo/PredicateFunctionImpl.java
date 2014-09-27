package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.common.LogicFormulationImpl;

public class PredicateFunctionImpl extends LogicFormulationImpl implements PredicateFunction{
	LogicFunctionTemplate template;
	PredicateFunctionEnvironment env;
	
	PredicateFunctionImpl(LogicFunctionTemplate template,PredicateFunctionEnvironment env) throws Exception{
		super();
		if(template==null)
			throw new Exception("Null template is invalid");
		this.template=template;
		this.setContext(env);
	}
	
	@Override
	public LogicFunctionTemplate getTemplate() {return this.template;}

	@Override
	public void setContext(RunnerEnvironment context) throws Exception {
		if(context==null)
			throw new Exception("Null context is invalid");
		if(!(context instanceof PredicateFunctionEnvironment))
			throw new ClassCastException("Invalid class cast from "
		+context.getClass().getName()+" to PredicateFunctionEnvironment");
		this.env=(PredicateFunctionEnvironment) context;
	}

	@Override
	public void setContext(Context context) throws Exception {
		if(context==null)
			throw new Exception("Null context is invalid");
		if(!(context instanceof PredicateFunctionEnvironment))
			throw new ClassCastException("Invalid class cast from "
		+context.getClass().getName()+" to PredicateFunctionEnvironment");
		this.env=(PredicateFunctionEnvironment) context;
	}

	@Override
	public void setContext(PredicateFunctionEnvironment context) throws Exception {
		if(context==null)
			throw new Exception("Null context is invalid");
		this.env=context;
	}

	@Override
	public PredicateFunctionEnvironment getContext() {return this.env;}

}
