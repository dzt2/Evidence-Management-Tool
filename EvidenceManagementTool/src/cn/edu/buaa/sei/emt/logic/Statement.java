package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface Statement extends ModelElement {
	
	public static final String TYPE_NAME = "logicformulation.Statement";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_CONTENT = "content";
	
	
	public String getContent();
	
	public void setContent(String value);
	
}
