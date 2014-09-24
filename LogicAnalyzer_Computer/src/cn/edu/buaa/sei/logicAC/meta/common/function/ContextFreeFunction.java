package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;

public interface ContextFreeFunction extends Function,ContextFreeComputable{
	public RunnerEnvironment getEnvironment();
	public void setEnvironment(RunnerEnvironment env);
}
