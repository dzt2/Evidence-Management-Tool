package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface PropositionVariable extends AtomFormulation, Variable {
	
	public static final String KEY_OBJECT = "object";
	public static final String TYPE_NAME = "logic_form.PropositionVariable";
	public static final String KEY_NAME = "name";
	public static final String KEY_VALUE = "value";
	public static final String KEY_T_VALUE = "t_value";
	
	
	public BooleanObject getT_value();
	
	public void setT_value(BooleanObject value);
	
}
