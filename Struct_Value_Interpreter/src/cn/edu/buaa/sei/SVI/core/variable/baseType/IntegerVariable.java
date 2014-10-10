package cn.edu.buaa.sei.SVI.core.variable.baseType;

import cn.edu.buaa.sei.SVI.core.variable.TypedVariable;

public interface IntegerVariable extends TypedVariable{
	/**
	 * Return the value to which the bindable refers.
	 * @exception Exception {Referencer} null referring variable.
	 * */
	public Integer read() throws Exception;
	/**
	 * Write the value to the bindable space.
	 * @exception Exception {TypedVariable} class cast failed.
	 * */
	public void assign(Integer val) throws Exception;
}
