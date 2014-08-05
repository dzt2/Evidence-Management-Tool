package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface LSet extends Value {
	
	public static final String TYPE_NAME = "value.LSet";
	public static final String KEY_VALUES = "values";
	
	
	public List<LObject> getValues();
	
}
