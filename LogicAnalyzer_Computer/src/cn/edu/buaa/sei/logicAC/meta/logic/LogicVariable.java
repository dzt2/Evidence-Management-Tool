package cn.edu.buaa.sei.logicAC.meta.logic;

import cn.edu.buaa.sei.logicAC.meta.common.TypedVariable;

public interface LogicVariable extends AtomicLogicFormulation,TypedVariable{
	public void assign(Boolean value);
	public Boolean read();
}
