package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface Negation extends LogicOperator {
	
	public static final String TYPE_NAME = "logic_form.Negation";
	public static final String KEY_FORMULATION = "formulation";
	
	
	public LogicFormulation getFormulation();
	
	public void setFormulation(LogicFormulation value);
	
}
