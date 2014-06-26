package cn.edu.buaa.sei.emt.core;
import java.util.List;

public interface ModelElement extends Element {
	
	public static final String TYPE_NAME = "core.ModelElement";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<TaggedValue> getTags();
	
	public String getId();
	
	public void setId(String value);
	
	public String getGid();
	
	public void setGid(String value);
	
	public List<Annotation> getAnnotations();
	
}
