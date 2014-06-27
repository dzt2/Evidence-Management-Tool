package cn.edu.buaa.sei.emt.process;
import java.util.List;

public interface Process extends PMElement {
	
	public static final String TYPE_NAME = "process.Process";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SUBORDINATE = "subordinate";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getName();
	
	public void setName(String value);
	
	public List<Process> getSubordinate();
	
}
