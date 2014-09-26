package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextDependFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;

public interface PredicateFunction extends LogicFunction,ContextDependFunction{
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
