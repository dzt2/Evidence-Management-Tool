package cn.edu.buaa.sei.SVI.group;

import cn.edu.buaa.sei.SVI.core.expression.UnaryOperator;
import cn.edu.buaa.sei.SVI.core.extend.GroupStruct;

public interface Complement extends GroupOperator,UnaryOperator{
	/**
	 * Return the operand of the UnaryOperator.
	 * */
	public GroupStruct getOperand();
	/**
	 * Set the operand of the UnaryOperator.
	 * @exception Exception operand==null
	 * */
	public void setOperand(GroupStruct operand) throws Exception;
}
