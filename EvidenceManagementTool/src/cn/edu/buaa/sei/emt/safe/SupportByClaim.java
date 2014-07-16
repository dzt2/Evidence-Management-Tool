package cn.edu.buaa.sei.emt.safe;

public interface SupportByClaim extends SMainRelation {
	
	public static final String TYPE_NAME = "safe.SupportByClaim";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_PREMISE = "premise";
	public static final String KEY_GID = "gid";
	public static final String KEY_CONCLUSION = "conclusion";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Claim getPremise();
	
	public void setPremise(Claim value);
	
	public ImplClaim getConclusion();
	
	public void setConclusion(ImplClaim value);
	
}
