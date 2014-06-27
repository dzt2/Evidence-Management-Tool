package cn.edu.buaa.sei.emt.assurance;

public interface EvidenceStatus extends EvidenceProperty {
	
	public static final String TYPE_NAME = "evidence.EvidenceStatus";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public int getType();
	
	public void setType(int value);
	
}
