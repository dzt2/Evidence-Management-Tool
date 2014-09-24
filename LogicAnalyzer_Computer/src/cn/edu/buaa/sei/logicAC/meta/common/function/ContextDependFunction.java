package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextDependComputable;

public interface ContextDependFunction extends Function,ContextDependComputable{
	public void setEnvironment(RunnerEnvironment context) throws Exception;
	public RunnerEnvironment getEnvironment();
}
