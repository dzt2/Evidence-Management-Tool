package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface LRelation extends Value {
	
	public static final String TYPE_NAME = "value.LRelation";
	public static final String KEY_NAME = "name";
	public static final String KEY_ELEMENTS = "elements";
	
	
	public String getName();
	
	public void setName(String value);
	
	public List<LObject> getElements();
	
}
