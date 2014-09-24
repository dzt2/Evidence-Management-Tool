package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Expression;

public interface LogicExpression extends Expression,LogicFormulation{
	public LogicOperator getOperator();
}
