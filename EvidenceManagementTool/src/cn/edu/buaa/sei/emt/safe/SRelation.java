package cn.edu.buaa.sei.emt.safe;

public interface SRelation extends SElement {
	
	public static final String TYPE_NAME = "safe.SRelation";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public SNode getSource();
	
	public void setSource(SNode value);
	
	public SNode getTarget();
	
	public void setTarget(SNode value);
	
}
