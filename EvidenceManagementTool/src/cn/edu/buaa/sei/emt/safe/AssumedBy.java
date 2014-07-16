package cn.edu.buaa.sei.emt.safe;

public interface AssumedBy extends SUtilityRelation {
	
	public static final String TYPE_NAME = "safe.AssumedBy";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ASSERTION = "assertion";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_ASSUMPTION = "assumption";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Assumption getAssumption();
	
	public void setAssumption(Assumption value);
	
	public Assertion getAssertion();
	
	public void setAssertion(Assertion value);
	
}
