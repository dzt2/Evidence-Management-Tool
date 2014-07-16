package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface Claim extends SMainNode, Assertion {
	
	public static final String KEY_SUPPORT_CLAIMS = "support_claims";
	public static final String KEY_ASSUMED_RESULT = "assumed_result";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_ASSUMPTIONS = "assumptions";
	public static final String KEY_VALID = "valid";
	public static final String KEY_SUPPORT_INFERENCES = "support_inferences";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String TYPE_NAME = "safe.Claim";
	public static final String KEY_RESULT = "result";
	public static final String KEY_NAME = "name";
	public static final String KEY_JUSTIFICATIONS = "justifications";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_STATE = "state";
	public static final String KEY_CONTEXTS = "contexts";
	
	
	public boolean getResult();
	
	public void setResult(boolean value);
	
	public int getState();
	
	public void setState(int value);
	
	public boolean getAssumed_result();
	
	public void setAssumed_result(boolean value);
	
	public List<Inference> getSupport_inferences();
	
	public List<ImplClaim> getSupport_claims();
	
}
