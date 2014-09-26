package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

/**
 * <b>Q(domain,scope)</b><br>
 * QuantifierOperator is BinaryOperator with two operands: domain & scope.<br>
 * */
public interface QuantifierOperator extends BinaryOperator{
	/**
	 * Set the two operands of BinaryOperator.<br>
	 * @exception Exception domain==null
	 * @exception Exception scope ==null
	 * */
	public void setOperands(DiscourseDomain domain,LogicFormulation scope) throws Exception;
	
	/**
	 * Return the domain of the quantifier
	 * */
	public DiscourseDomain getDomain();
	/**
	 * Return the scope of the quantifier
	 * */
	public LogicFormulation getScope();
}
