package cn.edu.buaa.sei.logicAC.meta.common.context;

import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

/**
 * NormativeParameterList is normative parameter list, which contains exactly one output parameter (return).<br>
 * <b>[o1] func_name (x1,x2,...)</b><br>
 * */
public interface NormativeParameterList extends Context{
	public static final int MAX_ARGUMENTS = 128;
	/**
	 * Set the return variable.<br>
	 * The output parameter could be null if nothing is going to be returned.
	 * */
	public void setOutputParameter(Variable parameter);
	/**
	 * Return the output parameter variable.
	 * */
	public Variable getOutputParameter();
	/**
	 * Add new input arguments in the list.<br>
	 * If this.containArgument(variable), do nothing.
	 * @exception Exception variable==null
	 * */
	public void addArgument(Variable variable) throws Exception;
	/**
	 * Remove the argument from input arguments.
	 * @exception Exception variable==null
	 * @exception Exception !this.containVariable(variable)
	 * */
	public void removeArgument(Variable variable) throws Exception;
	/**
	 * Checking whether the variable is in  arguments.
	 * */
	public boolean containArgument(Variable variable);
	/**
	 * Return the length of input arguments.
	 * */
	public int argumentSize();
	/**
	 * Return the ith argument in input arguments.
	 * @exception Exception i out of range: [0,size)
	 * */
	public Variable getArgument(int i) throws Exception;
	
}
