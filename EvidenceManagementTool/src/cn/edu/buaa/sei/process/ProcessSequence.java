package cn.edu.buaa.sei.process;

public interface ProcessSequence extends PMElement {
	
	public static final String TYPE_NAME = "process.ProcessSequence";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Process getSource();
	
	public void setSource(Process value);
	
	public Process getTarget();
	
	public void setTarget(Process value);
	
	public int getType();
	
	public void setType(int value);
	
}
