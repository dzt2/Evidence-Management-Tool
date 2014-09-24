package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.MultipleOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public interface Disjunction extends LogicOperator,MultipleOperator{
	public void setChildren(LogicFormulation[] children) throws Exception;
}
