package cn.edu.buaa.sei.logicAC.meta.common.context;

import java.util.Iterator;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public interface VariablePool extends Context{
	public boolean containVariable(Variable variable);
	public void appendVariable(Variable variable);
	public void removeVariable(Variable variable);
	
	Iterator<Variable> iterator();
}
