package core;

public interface ModelElement extends Element {
	
	public static final String TYPE_NAME = "core.ModelElement";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	
	
	public String getId();
	
	public void setId(String value);
	
	public String getGid();
	
	public void setGid(String value);
	
}
