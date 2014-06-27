package cn.edu.buaa.sei.emt.assurance;

public interface Claim extends Assertion {
	
	public static final String TYPE_NAME = "argument.Claim";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_ASSURED = "assured";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_SUPPORTED = "supported";
	
	
	public boolean getSupported();
	
	public void setSupported(boolean value);
	
	public boolean getAssured();
	
	public void setAssured(boolean value);
	
}
