package cn.edu.buaa.sei.logicAC.meta.logic.common;
import cn.edu.buaa.sei.logicAC.meta.common.function.Function;

/**
 * LogicFunction is the function used in logic computation.
 * */
public interface LogicFunction extends Function,LogicFormulation{
	/**
	 * Return the template of function as its declaration.<br>
	 * FunctionTemplate defines the structure of function.
	 * */
	public LogicFunctionTemplate getTemplate();
}
