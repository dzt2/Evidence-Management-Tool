package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.context.ParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.var.FreeVariable;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.BooleanVariable;

/**
 * LogicParameterList is ParameterList that used in logic predicate function.
 * */
public interface LogicParameterList extends ParameterList{
	/**
	 * Set the output parameter as a Boolean variable, since all logic function return Boolean.
	 * @exception Exception output == null
	 * */
	public void setOutputParameter(BooleanVariable output) throws Exception;
	/**
	 * Return the output Boolean variable as a parameter
	 * */
	public BooleanVariable getOutputParameter();
	
	/**
	 * Set the Input Arguments Variables. No type is constrained on these variables.<br>
	 * For Unary/Binary/Multiple Predicate, the length has been set to be correct.
	 * @exception Exception arguments==null
	 * @exception Exception arguments.length < 1
	 * */
	public void setArguments(FreeVariable[] arguments);
	/**
	 * Return all the arguments variables.
	 * */
	public FreeVariable[] getArguments();
}
