package cn.edu.buaa.sei.SVI.interpreter.core;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

/**
 * RegisterMachine is a <b>Static Analyzer</b> for selecting the right interpreter
 * for a given Struct input.<br>
 * The interpreter needs to be binded with a type of Struct before the whole interpretation starts.
 * */
public interface RegisterMachine {
	/**
	 * Bind Struct with a type of Interpreter.
	 * @exception Exception type==null||iType==null;
	 * @exception Exception iType.isInstanceable == false;
	 * */
	public void register(Class<Struct> type,Class<Interpreter> iType) throws Exception;
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
	public void logoff(Class<Struct> type);
}
