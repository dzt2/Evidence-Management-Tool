package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.ParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.core.Template;

public interface FunctionTemplate extends Template{
	public String getName();
	
	public ParameterList getParameters();
	public void setParameters(ParameterList plist) throws Exception;
}
