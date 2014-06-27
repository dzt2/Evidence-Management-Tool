package cn.edu.buaa.sei.emt.assurance;
import java.util.List;

public interface Argumentation extends SafeModelElement {
	
	public static final String TYPE_NAME = "argument.Argumentation";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_TOP_OBJECTIVE = "top_objective";
	public static final String KEY_ELEMENTS = "elements";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<ArgumentElement> getElements();
	
	public Claim getTop_objective();
	
	public void setTop_objective(Claim value);
	
}
