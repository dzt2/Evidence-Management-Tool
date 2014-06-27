package cn.edu.buaa.sei.emt.assurance;

public interface EvidenceEvent extends EvidenceElement {
	
	public static final String TYPE_NAME = "evidence.EvidenceEvent";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_EXECUTOR = "executor";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public SafeRole getExecutor();
	
	public void setExecutor(SafeRole value);
	
	public Evidence getEvidence();
	
	public void setEvidence(Evidence value);
	
	public int getType();
	
	public void setType(int value);
	
}
