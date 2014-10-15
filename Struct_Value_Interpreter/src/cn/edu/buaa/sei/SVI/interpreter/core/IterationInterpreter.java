package cn.edu.buaa.sei.SVI.interpreter.core;

/**
 * <i>IterationInterpreter</i> is the interpreter whose interpretation depends on other interpreters.<br>
 * As a result, it has to depend on <b>RegisterMachine</b>, a <b>Static Analyzer</b> to decide which 
 * interpreter to be used.
 * */
public interface IterationInterpreter extends Interpreter{
	/**
	 * Return the register machine.
	 * */
	public RegisterMachine getRegisterMachine();
}
