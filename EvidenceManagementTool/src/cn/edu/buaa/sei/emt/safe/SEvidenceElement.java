package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface SEvidenceElement extends ModelElement {
	
	public static final String TYPE_NAME = "evidence.SEvidenceElement";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getName();
	
	public void setName(String value);
	
}
