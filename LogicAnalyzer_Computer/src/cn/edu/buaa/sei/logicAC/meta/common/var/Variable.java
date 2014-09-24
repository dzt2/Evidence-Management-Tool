package cn.edu.buaa.sei.logicAC.meta.common.var;

/**
 * Variable is a Bindable with specified name.<br>
 * Variable provides access value in memory space by name.
 * */
public interface Variable extends Bindable{
	/**
	 * Return the Variable Name
	 * */
	public String getName();
}
