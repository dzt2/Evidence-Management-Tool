package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;

public interface BinaryLogicOperator extends FixedLogicOperator,BinaryOperator{
	/**
	 * Set the two operands of BinaryOperator.<br>
	 * Left is assigned to left operand and another for right operand.
	 * @exception Exception left==null || right==null
	 * */
	public void setOperands(LogicFormulation left,LogicFormulation right) throws Exception;
	/**
	 * Return the left operand in the operator
	 * */
	public LogicFormulation getLeft();
	/**
	 * Return the right operand in the operator
	 * */
	public LogicFormulation getRight();
}
