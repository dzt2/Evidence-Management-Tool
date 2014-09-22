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
	 * */
	public void addParameter(Parameter parameter);
	/**
	 * Check whether the parameter is in the function's parameter list
	 * */
	public boolean containParameter(Parameter parameter);
	/**
	 * Remove the parameter in function's parameter list
	 * */
	public void removeParameter(Parameter parameter);
	/**
	 * Get parameter by name
	 * */
	public Parameter getParameter(String name);
	/**
	 * Get parameter by index
	 * */
	public Parameter getParameter(int i);
}
