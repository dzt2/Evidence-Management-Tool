package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface EntityIndividual extends EntityElement {
	
	public static final String TYPE_NAME = "data.EntityIndividual";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_VALUE = "value";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public ModelElement getValue();
	
	public void setValue(ModelElement value);
	
}
