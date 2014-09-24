package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Expression;

/**
 * Expression in logic computation.
 * */
public interface LogicExpression extends Expression,LogicFormulation{
	/**
	 * The operator of logic expression must be a logic operator.
	 * */
	public LogicOperator getOperator();
}
