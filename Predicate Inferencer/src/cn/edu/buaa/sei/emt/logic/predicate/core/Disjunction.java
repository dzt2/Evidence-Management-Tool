package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface Disjunction extends LogicOperator {
	
	public static final String TYPE_NAME = "logic_form.Disjunction";
	public static final String KEY_FORMULATIONS = "formulations";
	
	
	public List<LogicFormulation> getFormulations();
	
}
