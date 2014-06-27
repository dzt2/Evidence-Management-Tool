package cn.edu.buaa.sei.emt.assurance;
import java.util.List;

public interface EvidenceGroup extends Evidence {
	
	public static final String TYPE_NAME = "evidence.EvidenceGroup";
	public static final String KEY_PROPERTIES = "properties";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SUB_EVIDENCES = "sub_evidences";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<Evidence> getSub_evidences();
	
}
