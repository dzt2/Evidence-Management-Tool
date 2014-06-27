package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface Role extends ModelElement {
	
	public static final String TYPE_NAME = "process.Role";
	public static final String KEY_PERSON = "person";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Person getPerson();
	
	public void setPerson(Person value);
	
	public String getName();
	
	public void setName(String value);
	
}
