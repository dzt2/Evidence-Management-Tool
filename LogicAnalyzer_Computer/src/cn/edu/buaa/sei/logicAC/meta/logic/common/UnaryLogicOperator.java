package cn.edu.buaa.sei.logicAC.meta.logic.common;
import cn.edu.buaa.sei.logicAC.meta.common.expr.UnaryOperator;

public interface UnaryLogicOperator extends FixedLogicOperator,UnaryOperator{
	/**
	 * Set the operand of UnaryOperator.
	 * @exception Exception operand==null
	 * */
	public void setOperand(LogicFormulation operand) throws Exception;
	/**
	 * Return the only one operand in Unary Operator
	 * */
	public LogicFormulation getOperand();
}
