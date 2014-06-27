package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface ProcessRecord extends ModelElement {
	
	public static final String TYPE_NAME = "process.ProcessRecord";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STARTTIME = "startTime";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ENDTIME = "endTime";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public String getStartTime();
	
	public void setStartTime(String value);
	
	public String getEndTime();
	
	public void setEndTime(String value);
	
}
