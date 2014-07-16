package cn.edu.buaa.sei.emt.safe;

public interface SupportByInference extends SMainRelation {
	
	public static final String TYPE_NAME = "safe.SupportByInference";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_INFERENCE = "inference";
	public static final String KEY_GID = "gid";
	public static final String KEY_CONCLUSION = "conclusion";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Inference getInference();
	
	public void setInference(Inference value);
	
	public ImplClaim getConclusion();
	
	public void setConclusion(ImplClaim value);
	
}
