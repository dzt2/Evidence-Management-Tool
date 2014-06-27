package cn.edu.buaa.sei.process;

public interface ArtifactRelation extends PMElement {
	
	public static final String TYPE_NAME = "process.ArtifactRelation";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Artifact getSource();
	
	public void setSource(Artifact value);
	
	public Artifact getTarget();
	
	public void setTarget(Artifact value);
	
	public int getType();
	
	public void setType(int value);
	
}
