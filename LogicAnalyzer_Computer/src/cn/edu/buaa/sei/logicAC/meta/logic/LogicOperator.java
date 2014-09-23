package cn.edu.buaa.sei.logicAC.meta.logic;

import cn.edu.buaa.sei.logicAC.meta.common.Operator;

public interface LogicOperator extends Operator{
	public LogicFormulation[] getParameters();
	public void setParameters(LogicFormulation[] parameters)throws Exception;
	public LogicFormulation getParameter(int i) throws Exception;
}
