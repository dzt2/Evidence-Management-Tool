package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface DiscourseDomain extends Bindable {
	
	public static final String TYPE_NAME = "variable.DiscourseDomain";
	public static final String KEY_NAME = "name";
	public static final String KEY_VALUE = "value";
	public static final String KEY_SET = "set";
	
	
	public LSet getSet();
	
	public void setSet(LSet value);
	
}
