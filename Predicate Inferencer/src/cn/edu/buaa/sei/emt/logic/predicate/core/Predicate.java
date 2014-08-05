package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface Predicate extends Bindable {
	
	public static final String TYPE_NAME = "variable.Predicate";
	public static final String KEY_NAME = "name";
	public static final String KEY_VALUE = "value";
	public static final String KEY_VARIABLES = "variables";
	
	
	public List<Variable> getVariables();
	
}
