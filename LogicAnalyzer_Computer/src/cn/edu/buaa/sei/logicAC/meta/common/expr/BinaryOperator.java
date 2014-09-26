package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

/**
 * Left OP Right<br>
 * FixedOperator with exactly two operands, including "+", "-", "*", "/", "%" ect...<br>
 * 
 * */
public interface BinaryOperator extends FixedOperator{
	/**
	 * Set the two operands of BinaryOperator.<br>
	 * Left is assigned to left operand and another for right operand.
	 * @exception Exception left==null || right==null
	 * */
	public void setOperands(Computable left,Computable right) throws Exception;
	/**
	 * Return the left operand in the operator
	 * */
	public Computable getLeft();
	/**
	 * Return the right operand in the operator
	 * */
	public Computable getRight();
}
