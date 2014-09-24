package cn.edu.buaa.sei.logicAC.meta.common.core;

/**
 * Computable is an object that could be computed, such as an expression, function, or a variable.<br>
 * Each computable has a result [object]. User can get it and the executer can set it after computation.
 * */
public interface Computable {
	/**
	 * Return the result of the computable. Before a computable is computed in executor, this returns null.
	 * */
	public Object getResult();
	/**
	 * Set the computed result of computable. Only the executable could do it.<br>
	 * Before any computation, executor needs to initialize the result as null, and set the computed result to it after execution.<br>
	 * After execution, the result still could be null, if the computable in its problem context is in-computable.
	 * */
	public void setResult(Object result);
}
