package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public interface Conjunction extends LogicOperator{
	public void setOperands(LogicFormulation[] operands) throws Exception;
}
