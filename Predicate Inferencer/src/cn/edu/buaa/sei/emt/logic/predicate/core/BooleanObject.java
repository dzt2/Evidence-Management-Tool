package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface BooleanObject extends LObject {
	
	public static final String TYPE_NAME = "value.BooleanObject";
	public static final String KEY_BOOL_VAL = "bool_val";
	public static final String KEY_ID = "id";
	
	
	public boolean getBool_val();
	
	public void setBool_val(boolean value);
	
}
