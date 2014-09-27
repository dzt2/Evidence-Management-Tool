package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextDependFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;

public interface PredicateFunction extends LogicFunction,ContextDependFunction{
	/**
	 * The template of LogicFunction must be LogicFunctionTemplate {as FunctionTemplate}
	 * */
	public LogicFunctionTemplate getTemplate();
	/**
	 * Set the context of the function [PredicateFunctionEnvironment]
	 * @exception Exception context==null
	 * */
	public void setContext(PredicateFunctionEnvironment context) throws Exception;
	/**
	 * Return the cotnext of function [PredicateFunctionEnvironment]
	 * */
	public PredicateFunctionEnvironment getContext();
}
