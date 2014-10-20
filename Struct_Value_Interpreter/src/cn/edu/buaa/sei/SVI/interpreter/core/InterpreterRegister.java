package cn.edu.buaa.sei.SVI.interpreter.core;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

/**
 * InterpreterRegister is a register for managing the relationships between Struct and Interpreter.
 * */
public interface InterpreterRegister {
	/**
	 * Bind Struct with a type of Interpreter.
	 * @exception Exception type==null||iType==null;
	 * @exception Exception iType.isInstanceable == false;
	 * */
	@SuppressWarnings("rawtypes")
	public void register(Class type,Class iType) throws Exception;
	/**
	 * Return an Interpreter for interpreting the given Struct.
	 * @exception Exception struct has not been binded with any interpreter.
	 * @exception Exception element==null
	 * */
	public Interpreter get(Struct element) throws Exception;
	/**
	 * Return whether a given element has been binded with Interpreter.
	 * */
	public boolean isRegistered(Struct element);
	/**
	 * Logoff a given Struct and its binded interpreter.
	 * */
	@SuppressWarnings("rawtypes")
	public void logoff(Class type);
}
