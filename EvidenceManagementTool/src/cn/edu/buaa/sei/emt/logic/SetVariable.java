package cn.edu.buaa.sei.emt.logic;

public interface SetVariable extends Variable {
	
	public static final String TYPE_NAME = "variable.SetVariable";
	public static final String KEY_BINDTO = "bindTo";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SET = "set";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public EntitySet getSet();
	
	public void setSet(EntitySet value);
	
}
