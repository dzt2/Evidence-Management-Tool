package cn.edu.buaa.sei.SVI.logic;

import cn.edu.buaa.sei.SVI.core.extend.LogicStruct;

/**
 * <i>QuantifierOperator</i> is a <i>LogicOperator</i> used in Quantifier.<br>
 * Its expression could be seen as a Quantifier. {we do not have such a class}.<br>
 * A <i>QuantifierOperator</i> could be: Universal, Existential, AtLeast, AtMost, Range
 * */
public interface QuantifierOperator extends LogicOperator{
	/**
	 * Return the domain of the Quantifier.
	 * */
	public DiscourseDomain getDomain();
	/**
	 * Return the scope logic element of the Quantifier.
	 * */
	public LogicStruct getScope();
}
