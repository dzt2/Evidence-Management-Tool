package cn.edu.buaa.sei.logicAC.meta.common.context;

import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter;

/**
 * GeneralParameterList presents a general structure of parameter list as follow:<br>
 * <b>[o1,o2,...] func_name (x1,x2,...)</b>
 * */
public interface GeneralParameterList extends ParameterList{
	/**
	 * Return the current length of Parameters in the list.
	 * */
	public int size();
	/**
	 * Return the ith parameter in list.
	 * @exception Exception i out of range [0,length)
	 * */
	public Parameter getParameter(int i) throws Exception;
	/**
	 * Add a new parameter into the list.<br>
	 * 	1) parameter has been defined in the list ==> do nothing.<br>
	 * 	2) parameter is null ==> Exception<br>
	 * @exception Exception parameter == null
	 * */
	public void addParameter(Parameter parameter) throws Exception;
	/**
	 * Remove an existing parameter in the list.<br>
	 * @exception Exception parameter == null
	 * @exception Exception parameter is not contained in the list.
	 * */
	public void removeParameter(Parameter parameter) throws Exception;
	/**
	 * Checking whether the specified parameter is in the list.
	 * */
	public boolean containParameter(Parameter parameter);
	
	/**
	 * Return all the parameters with specified type {IN|INOUT}<br>
	 * Note that: calling the function perhaps causes creating new List. It is better to avoid calling this method. 
	 * */
	public List<Parameter> getParameters();
	/**
	 * Return all the parameters with specified type {OUT|INOUT}<br>
	 * Note that: calling the function perhaps causes creating new List. It is better to avoid calling this method. 
	 * */
	public List<Parameter> getInParameters();
	/**
	 * Return all the parameters in the list. <br>
	 * Note that: calling the function perhaps causes creating new List. It is better to avoid calling this method. 
	 * */
	public List<Parameter> getOutParameters();
}
