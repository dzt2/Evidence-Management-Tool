package cn.edu.buaa.sei.emt.assurance;

public interface Time extends EvidenceProperty {
	
	public static final String TYPE_NAME = "evidence.Time";
	public static final String KEY_END = "end";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_START = "start";
	
	
	public String getStart();
	
	public void setStart(String value);
	
	public String getEnd();
	
	public void setEnd(String value);
	
}
