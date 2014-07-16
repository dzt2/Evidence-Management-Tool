package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface ImplClaim extends Claim {
	
	public static final String KEY_INFERENCES = "inferences";
	public static final String KEY_ASSUMED_RESULT = "assumed_result";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SUB_CLAIMS = "sub_claims";
	public static final String KEY_ASSUMPTIONS = "assumptions";
	public static final String KEY_VALID = "valid";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCES = "evidences";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String TYPE_NAME = "safe.ImplClaim";
	public static final String KEY_RESULT = "result";
	public static final String KEY_NAME = "name";
	public static final String KEY_JUSTIFICATIONS = "justifications";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_STATE = "state";
	public static final String KEY_CONTEXTS = "contexts";
	
	
	public List<Claim> getSub_claims();
	
	public List<Inference> getInferences();
	
	public List<EvidenceRef> getEvidences();
	
}
