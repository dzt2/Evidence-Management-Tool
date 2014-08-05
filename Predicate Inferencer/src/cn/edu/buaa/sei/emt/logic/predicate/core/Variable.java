package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface Variable extends Bindable {
	
	public static final String KEY_OBJECT = "object";
	public static final String TYPE_NAME = "variable.Variable";
	public static final String KEY_NAME = "name";
	public static final String KEY_VALUE = "value";
	
	
	public LObject getObject();
	
	public void setObject(LObject value);
	
}
