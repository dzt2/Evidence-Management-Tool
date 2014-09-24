package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.function.Function;

/**
 * LogicFunction is the function used in logic computation.
 * */
public interface LogicFunction extends Function,LogicFormulation{
	/**
	 * The template of LogicFunction must be LogicFunctionTemplate {as FunctionTemplate}
	 * */
	public LogicFunctionTemplate getTemplate();
}
