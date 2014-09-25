package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public class LogicOperatorImpl implements LogicOperator{
	LogicFormulation[] operands;
	
	@Override
	public LogicFormulation[] getOperands(){return this.operands;}
}
