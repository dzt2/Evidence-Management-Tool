package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.function.Function;

public interface LogicFunction extends Function,LogicFormulation{
	public void setTemplate(LogicFunctionTemplate template);
	public LogicFunctionTemplate getTemplate();
}
