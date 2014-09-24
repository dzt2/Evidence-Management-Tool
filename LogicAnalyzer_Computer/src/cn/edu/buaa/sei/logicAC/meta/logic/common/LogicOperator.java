package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;

/**
 * LogicOperator is specialized used in logic expression.<br>
 * LogicOperator relates LogicFormulation as operands.
 * */
public interface LogicOperator extends Operator{
	/**
	 * Return all the operands of logic formulations
	 * */
	public LogicFormulation[] getOperands();
}
