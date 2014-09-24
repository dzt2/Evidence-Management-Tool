package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.function.FunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.BooleanVariable;

public interface LogicFunctionTemplate extends FunctionTemplate{
	public void setOutParameter(BooleanVariable output);
}
