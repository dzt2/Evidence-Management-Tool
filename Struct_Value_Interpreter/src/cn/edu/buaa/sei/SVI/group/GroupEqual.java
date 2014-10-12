package cn.edu.buaa.sei.SVI.group;

import cn.edu.buaa.sei.SVI.core.expression.BinaryOperator;
import cn.edu.buaa.sei.SVI.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.logic.LogicOperator;

/**
 * GroupEqual is a <i>LogicOperator</i> used to test whether two Group is equal, like "A=B"
 * */
public interface GroupEqual extends LogicOperator,BinaryOperator{
	/**
	 * Return the left operand.
	 * */
	public GroupStruct getLeftOperand();
	/**
	 * Return the right operand.
	 * */
	public GroupStruct getRightOperand();
	/**
	 * Set the both operands in BinaryOperator
	 * @exception Exception left==null||right==null
	 * */
	public void setOperands(GroupStruct left,GroupStruct right) throws Exception;
}
