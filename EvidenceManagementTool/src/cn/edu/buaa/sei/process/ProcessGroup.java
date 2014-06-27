package cn.edu.buaa.sei.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface ProcessGroup extends ModelElement {
	
	public static final String TYPE_NAME = "process.ProcessGroup";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_PROCESSES = "processes";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<Process> getProcesses();
	
	public String getName();
	
	public void setName(String value);
	
}
