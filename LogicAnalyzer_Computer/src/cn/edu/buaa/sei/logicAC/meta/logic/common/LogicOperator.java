package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;

public interface LogicOperator extends Operator{
	public LogicFormulation[] getChildren();
}
