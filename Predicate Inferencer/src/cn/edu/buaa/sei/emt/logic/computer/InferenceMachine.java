package cn.edu.buaa.sei.emt.logic.computer;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public interface InferenceMachine {
	public void setFormulation(LogicFormulation form);
	public LogicFormulation getFormulation();
	
	public Bindable getVariable(String name);
	public void setVariable(String name,Value val);
	
	public Boolean computable();
	public Boolean inference();
	public Boolean safeInference();
}
