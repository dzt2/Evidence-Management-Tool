package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Expression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public interface Quantifier extends Expression,LogicFormulation{
	public QuantifierOperator getOperator();
}
