package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.core.Template;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

/**
 * FunctionTemplate define the structure of declaration of function as:<br>
 * [o1,o2,...,om] func_name (x1,x2,...,xn)<br>
 * 1) Function Name: func_name<br>
 * 2) ParameterList: [o1...] & [x1...]
 * */
public interface FunctionTemplate extends Template{
	/**
	 * Return the function name*/
	public String getName();
	/**
	 * Return the output Variable
	 * */
	public Variable getOutputVariable();
	/**
	 * Return the arguments of input
	 * */
	public Variable[] getArguments();
	/**
	 * Set the input Arguments. Null arguments present no arguments
	 * @author dzt2
	 * @exception Exception arguments[i] == null
	 * */
	public void setArguments(Variable[] arguments) throws Exception;
}
