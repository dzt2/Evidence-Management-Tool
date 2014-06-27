package cn.edu.buaa.sei.emt.assurance;

public interface ArgumentReason extends ArgumentElement {
	
	public static final String TYPE_NAME = "argument.ArgumentReason";
	public static final String KEY_RELATION = "relation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_REASON = "reason";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getReason();
	
	public void setReason(String value);
	
	public AssertionRelation getRelation();
	
	public void setRelation(AssertionRelation value);
	
}
