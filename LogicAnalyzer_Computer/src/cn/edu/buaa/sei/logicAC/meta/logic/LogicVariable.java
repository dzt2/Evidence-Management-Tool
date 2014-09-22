package cn.edu.buaa.sei.logicAC.meta.logic;

import cn.edu.buaa.sei.logicAC.meta.common.Variable;

public interface LogicVariable extends LogicFormulation,Variable{
	public void setBool(Boolean value);
	public Boolean getBool();
}
