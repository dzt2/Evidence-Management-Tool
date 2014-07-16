package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface Assertion extends SElement {
	
	public static final String TYPE_NAME = "safe.Assertion";
	public static final String KEY_ASSUMPTIONS = "assumptions";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_JUSTIFICATIONS = "justifications";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_VALID = "valid";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_CONTEXTS = "contexts";
	
	
	public String getStatement();
	
	public void setStatement(String value);
	
	public boolean getValid();
	
	public void setValid(boolean value);
	
	public List<Assumption> getAssumptions();
	
	public List<Justification> getJustifications();
	
	public List<Context> getContexts();
	
}
