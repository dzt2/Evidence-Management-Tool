package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface BindableElement extends ModelElement {
	
	public static final String TYPE_NAME = "variable.BindableElement";
	public static final String KEY_BINDTO = "bindTo";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public EntityElement getBindTo();
	
	public void setBindTo(EntityElement value);
	
}
