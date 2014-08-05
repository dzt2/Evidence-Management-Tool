package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface Bindable extends ManagedObject {
	
	public static final String TYPE_NAME = "variable.Bindable";
	public static final String KEY_NAME = "name";
	public static final String KEY_VALUE = "value";
	
	
	public String getName();
	
	public void setName(String value);
	
	public Value getValue();
	
	public void setValue(Value value);
	
}
