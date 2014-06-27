package cn.edu.buaa.sei.emt.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface Organization extends ModelElement {
	
	public static final String TYPE_NAME = "process.Organization";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ROLES = "roles";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<Role> getRoles();
	
	public String getName();
	
	public void setName(String value);
	
}
