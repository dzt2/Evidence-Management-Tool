package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface Conjunction extends LogicOperator {
	
	public static final String TYPE_NAME = "logic_form.Conjunction";
	public static final String KEY_FORMULATIONS = "formulations";
	
	
	public List<LogicFormulation> getFormulations();
	
}
