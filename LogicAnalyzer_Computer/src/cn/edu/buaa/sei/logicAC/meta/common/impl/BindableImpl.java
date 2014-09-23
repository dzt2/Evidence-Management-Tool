package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.Bindable;
import cn.edu.buaa.sei.logicAC.meta.common.ComputedContext;

public abstract class BindableImpl implements Bindable{
	/**
	 * The value that is referred by the bindable.
	 * */
	Object val;

	/**
	 * Bindable does not need to be interpreted since they refer to value and interpreted as the value.
	 * @return true
	 * */
	@Override
	public boolean interpret(ComputedContext context) {return true;}

	/**
	 * Return the val that is referred by the bindable
	 * @return this.val
	 * */
	@Override
	public Object read() throws Exception {return this.val;}
	/**
	 * Set the val with a new value that is referred by the bindable.
	 * */
	@Override
	public void assign(Object val) throws Exception {this.val=val;}

}
