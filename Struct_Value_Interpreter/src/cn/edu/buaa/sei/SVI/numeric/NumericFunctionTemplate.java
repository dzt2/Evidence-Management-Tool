package cn.edu.buaa.sei.SVI.numeric;

import cn.edu.buaa.sei.SVI.core.function.FunctionTemplate;

public interface NumericFunctionTemplate extends FunctionTemplate,CompositeNumericStruct{
	/**
	 * Return the Function it is owned.
	 * */
	public NumericFunction getFunction();
	/**
	 * Set the Function it is owned.
	 * */
	public void setFunction(NumericFunction function);
	/**
	 * Return the numeric output Argument of the Function {with name "out"}
	 * */
	public NumericVariable getOutput();
}
