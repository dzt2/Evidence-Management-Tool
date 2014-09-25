package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

/**
 * Operator with variable number of operands.<br>
 * Op(x...)
 * */
public interface FlexibleOperator extends Operator{
	/**
	 * The maximum size of operands that can be set in a flexible operator.
	 * */
	public static final int MAX_OPERANDS = 128;
	/**
	 * Return the current length of operands
	 * */
	public int getCurrentSize();
	/**
	 * add a new operand in the operator.<br>
	 * Note that: If operand is contained in the operator, just add another one in the last position.
	 * @exception Exception operand==null
	 * */
	public void addOperand(Computable operand) throws Exception;
	/**
	 * Remove the existing first operand in the operator.<br>
	 * Note that: if there are more than one operand, just remove the first one.
	 * @exception Exception operand==null
	 * @exception Exception !this.containOperand(operand)
	 * */
	public void removeOperand(Computable operand) throws Exception;
	/**
	 * Checking whether an operand is in the operator.
	 * */
	public boolean containOperand(Computable operand);
}
