package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface PredicateFormulation extends AtomFormulation, Bindable {
	
	public static final String TYPE_NAME = "logic_form.PredicateFormulation";
	public static final String KEY_ARGUMENTS = "arguments";
	public static final String KEY_NAME = "name";
	public static final String KEY_VALUE = "value";
	public static final String KEY_VARIABLES = "variables";
	
	
	public List<Variable> getVariables();
	
}
