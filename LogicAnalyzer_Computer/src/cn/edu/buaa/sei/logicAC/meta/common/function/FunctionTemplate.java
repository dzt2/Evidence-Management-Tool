package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.ParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextDependComputable;

public interface FunctionTemplate extends ContextDependComputable{
	public String getName();
	
	public ParameterList getParameters();
	public void setParameters(ParameterList plist);
}
