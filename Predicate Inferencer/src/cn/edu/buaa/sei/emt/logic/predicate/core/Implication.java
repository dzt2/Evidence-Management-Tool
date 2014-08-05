package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface Implication extends LogicOperator {
	
	public static final String TYPE_NAME = "logic_form.Implication";
	public static final String KEY_PREMISE = "premise";
	public static final String KEY_CONCLUSION = "conclusion";
	
	
	public LogicFormulation getPremise();
	
	public void setPremise(LogicFormulation value);
	
	public LogicFormulation getConclusion();
	
	public void setConclusion(LogicFormulation value);
	
}
