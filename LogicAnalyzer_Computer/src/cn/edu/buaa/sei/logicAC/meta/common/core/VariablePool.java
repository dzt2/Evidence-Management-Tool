package cn.edu.buaa.sei.logicAC.meta.common.core;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public interface VariablePool extends Context{
	public boolean containVariable(String name);
	public void appendVariable(Variable variable);
	public void removeVariable(Variable variable);
	public Variable getVariable(String name) throws Exception;
	public Set<String> getVariableNames();
}
