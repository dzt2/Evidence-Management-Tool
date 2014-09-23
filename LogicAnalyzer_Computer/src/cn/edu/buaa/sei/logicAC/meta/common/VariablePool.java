package cn.edu.buaa.sei.logicAC.meta.common;

import java.util.Iterator;
import java.util.Set;

public interface VariablePool {
	/**
	 * Return the iterator that run the whole list of variables in the pool.
	 * */
	public Iterator<Variable> iterator();
	/**
	 * Return the number of variables currently in the pool space.
	 * */
	public int size();
	/**
	 * Return the variable with the specified name. 
	 * The exception would be caused when the specified name is not defined in the pool.
	 * */
	public Variable getVariableByName(String name) throws Exception;
	/**
	 * Return the set of all names in variable pool so to access them in pool by getVariableByName()
	 * */
	public Set<String> getNames();
	
	/**
	 * Put a new variable into the pool space.
	 * Exception would be caused when variable's name is conflict with other existing one.
	 * If the variable has been in pool space, do nothing and return.
	 * */
	public void putVariable(Variable var) throws Exception;
	/**
	 * Delete a existing variable from the pool space.
	 * Exception would be caused if the variable is not defined in the pool.
	 * */
	public void deleteVariable(Variable var) throws Exception;
	/**
	 * Check whether the variable is in the pool space.
	 * */
	public boolean containVariable(Variable var);
}
