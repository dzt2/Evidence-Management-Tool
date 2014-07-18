package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface Evidence extends SEvidenceElement {
	
	public static final String TYPE_NAME = "evidence.Evidence";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SUPPORT_REFS = "support_refs";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<EvidenceRef> getSupport_refs();
	
}
