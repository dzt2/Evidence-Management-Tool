package cn.edu.buaa.sei.logicAC.meta.logic.fo;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;

public interface PredicateFunction extends LogicFunction{
	/**
	 * Return the context of the function is running
	 * */
	public PredicateFunctionEnvironment getEnvironment();
	/**
	 * Set another environment of the function to be executed.<br>
	 * Environment defines the required values for function to exectute.
	 * @exception Exception env == null
	 * */
	public void setEnvironment(PredicateFunctionEnvironment env) throws Exception;
}
