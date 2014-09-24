package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public interface Implication extends LogicOperator,BinaryOperator{
	public void setOperands(LogicFormulation precondition,LogicFormulation conclusion) throws Exception;
}
