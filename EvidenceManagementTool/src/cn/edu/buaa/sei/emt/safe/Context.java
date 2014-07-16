package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface Context extends SUtilityNode, SInformationElement {
	
	public static final String TYPE_NAME = "safe.Context";
	public static final String KEY_ASSERTIONS = "assertions";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<Assertion> getAssertions();
	
}
