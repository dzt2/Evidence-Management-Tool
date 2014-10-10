package cn.edu.buaa.sei.SVI.core;

/**
 * Interpreter <i>{abstract}</i> is an computer that could compute the result of a given struct.<br>
 * Struct presents the structure of computed objects.<br>
 * Interpreter analyze and compute the result of the struct.<br>
 * ------------------------------------------------------------------------------------------------------<br>
 * For Bindable, interpreter return the value in which the variable stores --> <b>MemoryReader</b><br>
 * For Expression, interpreter return the computation result of the expression --> <b>ExpressionInterpreter</b><br>
 * For Function, interpreter run the function and set the output parameters values based on arguments. --> <b>FunctionInterpreter</b><br>
 * For Program, interpreter schedule the statements in it and complete all the computations in steps. --> <b>Executor</b>
 * */
public interface Interpreter {
	/**
	 * Register the struct element so to interpret it.<br>
	 * @exception Exception element==null
	 * @exception Exception this.element.getClass() is wrong.
	 * */
	public void register(Struct element) throws Exception;
}
