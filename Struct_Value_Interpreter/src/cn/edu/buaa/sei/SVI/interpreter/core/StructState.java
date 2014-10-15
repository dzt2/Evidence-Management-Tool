package cn.edu.buaa.sei.SVI.interpreter.core;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

/**
 * StructState is the state of Struct, in which struct is the input of interpreter and result
 * is the result from interpreter after computation.
 * */
public interface StructState {
	/**
	 * Return the element to be interpreted.
	 * */
	public Struct getStruct();
	/**
	 * Return the result after interpretation.
	 * */
	public Object getResult();
}
