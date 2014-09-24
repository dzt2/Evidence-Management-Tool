package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextDependComputable;

/**
 * Function whose computation depends on external variables.<br>
 * 1) ParameterList in template. {not environment}<br>
 * 2) Context in Computable. {environment}
 * */
public interface ContextDependFunction extends Function,ContextDependComputable{
	/**
	 * Set the context of the function [RunnerEnvironment]
	 * @exception Exception context==null
	 * */
	public void setContext(RunnerEnvironment context) throws Exception;
	/**
	 * Return the cotnext of function [RunnerEnvironment]
	 * */
	public RunnerEnvironment getContext();
}
