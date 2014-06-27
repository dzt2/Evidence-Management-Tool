package cn.edu.buaa.sei.emt.assurance;
import java.util.List;

public interface Evidence extends EvidenceElement {
	
	public static final String TYPE_NAME = "evidence.Evidence";
	public static final String KEY_PROPERTIES = "properties";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<EvidenceProperty> getProperties();
	
}
