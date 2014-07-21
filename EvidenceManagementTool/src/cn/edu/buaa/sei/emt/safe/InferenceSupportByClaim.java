package cn.edu.buaa.sei.emt.safe;

public interface InferenceSupportByClaim extends SMainRelation {
	
	public static final String TYPE_NAME = "safe.InferenceSupportByClaim";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_INFERENCE = "inference";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_CLAIM = "claim";
	
	
	public Inference getInference();
	
	public void setInference(Inference value);
	
	public Claim getClaim();
	
	public void setClaim(Claim value);
	
}
