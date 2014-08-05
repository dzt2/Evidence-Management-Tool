package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface Equivalence extends LogicOperator {
	
	public static final String KEY_FORMULATION1 = "formulation1";
	public static final String TYPE_NAME = "logic_form.Equivalence";
	public static final String KEY_FORMULATION2 = "formulation2";
	
	
	public LogicFormulation getFormulation1();
	
	public void setFormulation1(LogicFormulation value);
	
	public LogicFormulation getFormulation2();
	
	public void setFormulation2(LogicFormulation value);
	
}
