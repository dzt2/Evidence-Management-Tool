package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.ModelElement;

public interface ResponsibleAssign extends ModelElement {
	
	public static final String KEY_ARTIFACT = "artifact";
	public static final String TYPE_NAME = "process.ResponsibleAssign";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ROLE = "role";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Artifact getArtifact();
	
	public void setArtifact(Artifact value);
	
	public Role getRole();
	
	public void setRole(Role value);
	
	public int getType();
	
	public void setType(int value);
	
}
