package cn.edu.buaa.sei.emt.assurance;
import java.util.List;

public interface ContextRelation extends AssertionRelation {
	
	public static final String TYPE_NAME = "argument.ContextRelation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_CONTEXTS = "contexts";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public List<Context> getContexts();
	
}
