package cn.edu.buaa.sei.emt.assurance;

public interface Custody extends EvidenceProperty {
	
	public static final String TYPE_NAME = "evidence.Custody";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ROLE = "role";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public SafeRole getRole();
	
	public void setRole(SafeRole value);
	
	public int getType();
	
	public void setType(int value);
	
}
