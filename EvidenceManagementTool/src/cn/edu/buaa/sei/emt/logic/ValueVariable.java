package cn.edu.buaa.sei.emt.logic;

public interface ValueVariable extends Variable {
	
	public static final String TYPE_NAME = "variable.ValueVariable";
	public static final String KEY_BINDTO = "bindTo";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_VALUE = "value";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public EntityValue getValue();
	
	public void setValue(EntityValue value);
	
}
