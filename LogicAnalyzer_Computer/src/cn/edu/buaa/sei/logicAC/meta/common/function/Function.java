package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

public interface Function extends Computable{
	public FunctionTemplate getTemplate();
	public void setTemplate(FunctionTemplate template);
}
