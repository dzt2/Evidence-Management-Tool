package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public interface Equivalence extends LogicOperator,BinaryOperator{
	public void setChildren(LogicFormulation left,LogicFormulation right);
}
