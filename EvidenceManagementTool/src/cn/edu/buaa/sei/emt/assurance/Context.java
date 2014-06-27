package cn.edu.buaa.sei.emt.assurance;

public interface Context extends ArgumentElement {
	
	public static final String TYPE_NAME = "argument.Context";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getDescription();
	
	public void setDescription(String value);
	
}
