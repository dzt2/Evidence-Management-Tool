package cn.edu.buaa.sei.SVI.core.variable;

import cn.edu.buaa.sei.SVI.core.Interpreter;

/**
 * MemoryReader is an interpreter for Bindable, to read the bindable's value and return it as a result.
 * */
public interface MemoryReader extends Interpreter{
	/**
	 * Register the bindable {struct} so to interpret it.<br>
	 * @exception Exception element==null
	 * */
	public void register(Bindable bindable) throws Exception;
	/**
	 * Reading the value of the Bindable and return it as a result.
	 * @exception Exception bindable == null
	 * */
	public Object interpret() throws Exception;
}
