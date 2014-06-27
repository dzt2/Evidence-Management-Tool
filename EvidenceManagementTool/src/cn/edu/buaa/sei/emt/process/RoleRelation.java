package cn.edu.buaa.sei.emt.process;

public interface RoleRelation extends PMElement {
	
	public static final String TYPE_NAME = "process.RoleRelation";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Role getSource();
	
	public void setSource(Role value);
	
	public Role getTarget();
	
	public void setTarget(Role value);
	
	public int getType();
	
	public void setType(int value);
	
}
