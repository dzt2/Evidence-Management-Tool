package cn.edu.buaa.sei.emt.logic;

public interface Variable extends BindableElement {
	
	public static final String TYPE_NAME = "variable.Variable";
	public static final String KEY_BINDTO = "bindTo";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getName();
	
	public void setName(String value);
	
}
