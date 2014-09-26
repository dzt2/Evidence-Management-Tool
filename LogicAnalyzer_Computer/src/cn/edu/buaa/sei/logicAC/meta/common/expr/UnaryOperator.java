package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

/**
 * OP x<br>
 * FixedOperator with only one operand, including "!"
 * */
public interface UnaryOperator extends FixedOperator{
	/**
	 * Set the operand of UnaryOperator.
	 * @exception Exception operand==null
	 * */
	public void setOperand(Computable operand) throws Exception;
	/**
	 * Return the only one operand in Unary Operator
	 * */
	public Computable getOperand();
}
