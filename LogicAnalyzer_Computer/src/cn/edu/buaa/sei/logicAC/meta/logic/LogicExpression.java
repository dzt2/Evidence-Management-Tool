package cn.edu.buaa.sei.logicAC.meta.logic;

import cn.edu.buaa.sei.logicAC.meta.common.Expression;

public interface LogicExpression extends LogicFormulation, Expression{
	public LogicOperator getOperator();
	public LogicFormulation getParameter(int i);
}
