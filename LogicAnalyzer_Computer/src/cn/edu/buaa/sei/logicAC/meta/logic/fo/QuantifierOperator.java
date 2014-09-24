package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public interface QuantifierOperator extends Operator{
	public DiscourseDomain getDomain();
	public LogicFormulation getScope();
}
