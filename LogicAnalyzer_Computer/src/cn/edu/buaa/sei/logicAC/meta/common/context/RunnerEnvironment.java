package cn.edu.buaa.sei.logicAC.meta.common.context;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public interface RunnerEnvironment extends Context{
	public Variable getVariable(String name) throws Exception;
	public boolean containVariable(Variable variable);
	public boolean containVariable(String name);
	public void appendVariable(Variable variable) throws Exception;
	public void removeVariable(Variable variable) throws Exception;
	
	public Set<String> getEnvNames();
}
