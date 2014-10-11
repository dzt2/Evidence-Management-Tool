package cn.edu.buaa.sei.SVI.core.variable.baseType;

import java.util.Set;

import cn.edu.buaa.sei.SVI.core.variable.TypedVariable;

public interface SetVariable extends TypedVariable{
	/**
	 * Return the value to which the bindable refers.
	 * */
	@SuppressWarnings("rawtypes")
	public Set read() throws Exception;
	/**
	 * Write the value to the bindable space.
	 * @exception Exception {TypedVariable} class cast failed.
	 * */
	@SuppressWarnings("rawtypes")
	public void assign(Set val) throws Exception;
}
