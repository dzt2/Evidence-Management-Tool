package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.ParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.core.Template;

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
	 * Return the parameter list of the function, including output parameter.
	 * */
	public ParameterList getParameters();
	/**
	 * Set the parameter list of function.
	 * @exception Exception plist==null
	 * */
	public void setParameters(ParameterList plist) throws Exception;
}
