package cn.edu.buaa.sei.emt.safe;

public interface SupportByEvidence extends SMainRelation {
	
	public static final String TYPE_NAME = "safe.SupportByEvidence";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public ImplClaim getObjective();
	
	public void setObjective(ImplClaim value);
	
	public EvidenceRef getEvidence();
	
	public void setEvidence(EvidenceRef value);
	
}
