package cn.edu.buaa.sei.SVI.logic;

import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.SetVariable;

/**
 * DiscourseDomain is a <i>CompositeLogicStruct</i> whose child is its iterator.<br>
 * DiscourseDomain is a SetVariable which could be assigned with Set Values.<br>
 * Iterator of the DiscourseDomain is named as "{domain}.iter"
 * */
public interface DiscourseDomain extends CompositeLogicStruct,SetVariable{
	/**
	 * Return the Iterator Variable.
	 * */
	public Variable getIterator();
}
