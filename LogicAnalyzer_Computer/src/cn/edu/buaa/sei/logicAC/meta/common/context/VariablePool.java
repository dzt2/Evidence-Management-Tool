package cn.edu.buaa.sei.logicAC.meta.common.context;

import java.util.Iterator;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

/**
 * VariablePool is a context to manage variable in it using set way: you can access variable by iterator, no other ways.
 * */
public interface VariablePool extends Context{
	/**
	 * Checking whether a variable has been put into the pool.
	 * */
	public boolean containVariable(Variable variable);
	/**
	 * Add a new variable into the pool. If it has been in the pool, do nothing.
	 * @exception Exception variable is null.
	 * */
	public void appendVariable(Variable variable) throws Exception;
	/**
	 * Remove a existing variable from the current context.
	 * @exception Exception variable is null
	 * @exception Exception variable is not in the pool
	 * */
	public void removeVariable(Variable variable) throws Exception;
	/**
	 * Return the iterator of the variables for accessing.
	 * */
	Iterator<Variable> iterator();
}
