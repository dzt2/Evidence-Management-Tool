package cn.edu.buaa.sei.logicAC.meta.logic.common;
import cn.edu.buaa.sei.logicAC.meta.common.expr.FlexibleOperator;

public interface FlexibleLogicOperator extends LogicOperator,FlexibleOperator{
	/**
	 * add a new operand in the logic operator.<br>
	 * Note that: If operand is contained in the operator, just add another one in the last position.
	 * @exception Exception operand==null
	 * */
	public void addOperand(LogicFormulation operand) throws Exception;
	/**
	 * Remove the existing first operand in the logic operator.<br>
	 * Note that: if there are more than one operand, just remove the first one.
	 * @exception Exception operand==null
	 * @exception Exception !this.containOperand(operand)
	 * */
	public void removeOperand(LogicFormulation operand) throws Exception;
	/**
	 * Checking whether an operand is in the logic operator.
	 * */
	public boolean containOperand(LogicFormulation operand);
}
