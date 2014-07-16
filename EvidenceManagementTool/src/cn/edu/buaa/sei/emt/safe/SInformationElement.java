package cn.edu.buaa.sei.emt.safe;

public interface SInformationElement extends SElement {
	
	public static final String TYPE_NAME = "safe.SInformationElement";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getDescription();
	
	public void setDescription(String value);
	
	public String getName();
	
	public void setName(String value);
	
}
