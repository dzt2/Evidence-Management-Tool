package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.UnaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public interface Negation extends LogicOperator,UnaryOperator{
	public void setChild(LogicFormulation child);
	public void setFormulation(LogicFormulation formulation);
}
