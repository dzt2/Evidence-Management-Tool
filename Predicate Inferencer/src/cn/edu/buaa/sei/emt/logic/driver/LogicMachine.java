package cn.edu.buaa.sei.emt.logic.driver;

import java.util.Set;

public interface LogicMachine {
	
	// input,construct,assignment
	public Boolean init();
	// getter and debug
	public Set<String> getVariableNames();
	public Object getVariable(String name);
	// computation --> results
	public Boolean compute(String name);
}
