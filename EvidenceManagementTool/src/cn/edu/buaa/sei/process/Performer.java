package cn.edu.buaa.sei.process;

public interface Performer extends PMElement {
	
	public static final String TYPE_NAME = "process.Performer";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ROLE = "role";
	public static final String KEY_PROCESS = "process";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Process getProcess();
	
	public void setProcess(Process value);
	
	public Role getRole();
	
	public void setRole(Role value);
	
	public int getType();
	
	public void setType(int value);
	
}
