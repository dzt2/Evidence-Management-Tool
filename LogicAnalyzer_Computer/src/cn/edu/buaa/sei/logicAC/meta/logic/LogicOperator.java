package cn.edu.buaa.sei.logicAC.meta.logic;

import cn.edu.buaa.sei.logicAC.meta.common.Operator;

public interface LogicOperator extends Operator{
	public LogicFormulation[] getParameters();
	public LogicFormulation getFormulation(int i);
}
