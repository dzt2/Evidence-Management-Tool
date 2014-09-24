package cn.edu.buaa.sei.logicAC.meta.common.context;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

/**
 * RunnerEnvironment provide environment for executable and computable to store required 
 * value in variables that could be assessed by name.<br>
 * 1) The variables in environment could be accessed by using their name.<br>
 * 2) In theory, variables in the environment should not have conflict name.<br>
 * 3) RunnerEnvironment provides hierachical framework to manage names of variables: if name is not found in 
 * this space, it would check in the parent's space until finding it or the parent is null.
 * */
public interface RunnerEnvironment extends Context{
	/**
	 * Return the variable in the space by using its name to access.<br>
	 * @exception Exception name == null
	 * @exception !this.env,space.contain(name) && (this.env!=null -> !this.env.parent.containVariable(name))
	 * */
	public Variable getVariable(String name) throws Exception;
	/**
	 * Checking whether a variable is in local space or its parent space.<br>
	 * Return false if name == null.
	 * @return this.env.map.containValue(variable) || this.env.parent.containVariable(variable);
	 * */
	public boolean containVariable(Variable variable);
	/**
	 * Checking whether the name is defined in local space or parent's space.<br>
	 * Return false if name == null.
	 * @return this.env.map.containKey(name) || this.env.parent.containVariable(name);
	 * */
	public boolean containVariable(String name);
	/**
	 * Add new variable into local space.<br>
	 * If this.containVariable(variable) ==> do nothing.
	 * @exception Exception variable == null
	 * @exception Exception this.map.containKey(variable.name);
	 * */
	public void appendVariable(Variable variable) throws Exception;
	/**
	 * Remove a existing variable from the local space of the environment.<br>
	 * Note that: variable in parent space cannot be removed.
	 * @exception Exception variable == null
	 * @exception Exception !this.map.containValue(variable)
	 * */
	public void removeVariable(Variable variable) throws Exception;
	/**
	 * Return all the names of variables in local space.
	 * */
	public Set<String> getEnvNames();
	/**
	 * Return the parent environment.
	 * */
	public RunnerEnvironment getParentEnvironment();
}
