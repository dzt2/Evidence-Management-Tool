package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface Justification extends SUtilityNode, Assertion {
	
	public static final String TYPE_NAME = "safe.Justification";
	public static final String KEY_ASSERTIONS = "assertions";
	public static final String KEY_NAME = "name";
	public static final String KEY_ASSUMPTIONS = "assumptions";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_JUSTIFICATIONS = "justifications";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_VALID = "valid";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_CONTEXTS = "contexts";
	
	
	public List<Assertion> getAssertions();
	
}
