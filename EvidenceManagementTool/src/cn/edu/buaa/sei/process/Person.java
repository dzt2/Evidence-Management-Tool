package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface Person extends ModelElement {
	
	public static final String TYPE_NAME = "process.Person";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_MAIL = "mail";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_SEX = "sex";
	
	
	public String getMail();
	
	public void setMail(String value);
	
	public String getSex();
	
	public void setSex(String value);
	
	public String getName();
	
	public void setName(String value);
	
}
