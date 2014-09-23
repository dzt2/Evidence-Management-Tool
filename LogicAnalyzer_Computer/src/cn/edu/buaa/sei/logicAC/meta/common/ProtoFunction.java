package cn.edu.buaa.sei.logicAC.meta.common;

import java.util.List;

public interface ProtoFunction {
	/**
	 * Return the name of the function
	 * */
	public String getName();
	
	/**
	 * Return Input Parameters
	 * */
	public List<Parameter> getInParamters();
	/**
	 * Return Output Parameters
	 * */
	public List<Parameter> getOutParameters();
	/**
	 * Return All Parameters
	 * */
	public List<Parameter> getAllParameters();
	/**
	 * Add new Parameter
	 * @throws Exception 
	 * */
	public void addParameter(Parameter parameter) throws Exception;
	/**
	 * Check whether the parameter is in the function's parameter list
	 * */
	public boolean containParameter(Parameter parameter);
	/**
	 * Remove the parameter in function's parameter list
	 * @throws Exception 
	 * */
	public void removeParameter(Parameter parameter) throws Exception;
	/**
	 * Get parameter by name
	 * @throws Exception 
	 * */
	public Parameter getParameter(String name) throws Exception;
	/**
	 * Get parameter by index
	 * @throws Exception 
	 * */
	public Parameter getParameter(int i) throws Exception;
	/**
	 * Return the length of the paramter list in function
	 * */
	public int size();
}
