package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.ParameterList;

public interface FunctionTemplate {
	public String getName();
	
	public ParameterList getParameters();
	public void setParameters(ParameterList plist);
}
