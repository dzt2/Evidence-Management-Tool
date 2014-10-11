package cn.edu.buaa.sei.SVI.exLogic;

import cn.edu.buaa.sei.SVI.core.function.FunctionTemplate;
import cn.edu.buaa.sei.SVI.core.variable.baseType.BooleanVariable;

/**
 * LogicFunctionTemplate is the template of LogicFunction. Its owner could only be LogicFunction.<br>
 * LogicFunction return Boolean Variable as its output.
 * */
public interface LogicFunctionTemplate extends CompositeLogicStruct,FunctionTemplate{
	/**
	 * Return the output boolean Argument of the Function {with name "out"}
	 * */
	public BooleanVariable getOutput();
	/**
	 * Return the Function it is owned.
	 * */
	public LogicFunction getFunction();
	/**
	 * Set the Function it is owned.
	 * */
	public void setFunction(LogicFunction function);
}
