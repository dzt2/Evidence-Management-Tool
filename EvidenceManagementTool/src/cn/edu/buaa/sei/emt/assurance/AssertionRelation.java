package cn.edu.buaa.sei.emt.assurance;

public interface AssertionRelation extends Assertion {
	
	public static final String TYPE_NAME = "argument.AssertionRelation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public Claim getObjective();
	
	public void setObjective(Claim value);
	
}
