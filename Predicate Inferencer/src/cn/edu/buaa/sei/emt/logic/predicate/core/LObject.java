package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface LObject extends Value {
	
	public static final String TYPE_NAME = "value.LObject";
	public static final String KEY_ID = "id";
	
	
	public String getId();
	
	public void setId(String value);
	
}
