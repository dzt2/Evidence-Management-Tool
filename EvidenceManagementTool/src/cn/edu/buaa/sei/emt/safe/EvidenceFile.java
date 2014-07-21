package cn.edu.buaa.sei.emt.safe;

public interface EvidenceFile extends Evidence {
	
	public static final String TYPE_NAME = "evidence.EvidenceFile";
	public static final String KEY_FILE_URL = "file_url";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SUPPORT_REFS = "support_refs";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getFile_url();
	
	public void setFile_url(String value);
	
}
