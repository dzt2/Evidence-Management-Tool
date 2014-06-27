package cn.edu.buaa.sei.emt.logic;
import java.util.List;

public interface EntityRelation extends EntityElement {
	
	public static final String TYPE_NAME = "data.EntityRelation";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ELEMENTS = "elements";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<EntityElement> getElements();
	
}
