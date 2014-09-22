package cn.edu.buaa.sei.logicAC.meta.common;

import java.util.Iterator;
import java.util.Set;

public interface VariablePool {
	public Iterator<Variable> iterator();
	public int size();
	public Variable getVariableByName(String name);
	public Set<String> getNames();
	
	public void putVariable(Variable var);
	public void deleteVariable(Variable var);
	public boolean containVariable(Variable var);
}
