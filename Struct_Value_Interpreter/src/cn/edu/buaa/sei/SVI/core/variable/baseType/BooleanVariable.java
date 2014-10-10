package cn.edu.buaa.sei.SVI.core.variable.baseType;

import cn.edu.buaa.sei.SVI.core.variable.TypedVariable;

public interface BooleanVariable extends TypedVariable{
	/**
	 * Return the value to which the bindable refers.
	 * */
	public Boolean read() throws Exception;
	/**
	 * Write the value to the bindable space.
	 * @exception Exception {TypedVariable} class cast failed.
	 * */
	public void assign(Boolean val) throws Exception;
}
