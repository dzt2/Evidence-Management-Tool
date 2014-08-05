package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface BooleanValue extends Value {
	
	public static final String TYPE_NAME = "value.BooleanValue";
	public static final String KEY_BOOL_VAL = "bool_val";
	
	
	public boolean getBool_val();
	
	public void setBool_val(boolean value);
	
}
