package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface LogicExpression extends LogicFormulation {
	
	public static final String TYPE_NAME = "logic_form.LogicExpression";
	public static final String KEY_NAME = "name";
	public static final String KEY_OPERATOR = "operator";
	
	
	public LogicOperator getOperator();
	
	public void setOperator(LogicOperator value);
	
}
