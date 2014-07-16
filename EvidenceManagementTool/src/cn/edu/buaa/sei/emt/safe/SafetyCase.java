package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface SafetyCase extends SModule {
	
	public static final String KEY_INFERENCES = "inferences";
	public static final String KEY_JUSTIFICATION_LINKS = "justification_links";
	public static final String KEY_ASSUMPTIONS = "assumptions";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_CLAIM_EVIDENCE_LINKS = "claim_evidence_links";
	public static final String KEY_CLAIM_INFERENCE_LINKS = "claim_inference_links";
	public static final String KEY_ASSUMPTION_LINKS = "assumption_links";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String TYPE_NAME = "case.SafetyCase";
	public static final String KEY_SUBMODULES = "subModules";
	public static final String KEY_CONTEXT_LINKS = "context_links";
	public static final String KEY_NODES = "nodes";
	public static final String KEY_JUSTIFICATIONS = "justifications";
	public static final String KEY_EVIDENCEREFS = "evidenceRefs";
	public static final String KEY_SUB_CASES = "sub_cases";
	public static final String KEY_IMPLCLAIMS = "implClaims";
	public static final String KEY_CLAIM_CLAIM_LINKS = "claim_claim_links";
	public static final String KEY_UNDEVCLAIMS = "undevClaims";
	public static final String KEY_RELATIONS = "relations";
	public static final String KEY_CONTEXTS = "contexts";
	
	
	public List<ImplClaim> getImplClaims();
	
	public List<Inference> getInferences();
	
	public List<SupportByEvidence> getClaim_evidence_links();
	
	public List<AssumedBy> getAssumption_links();
	
	public List<UndevClaim> getUndevClaims();
	
	public List<JustifiedBy> getJustification_links();
	
	public List<Assumption> getAssumptions();
	
	public List<EvidenceRef> getEvidenceRefs();
	
	public List<Justification> getJustifications();
	
	public List<Context> getContexts();
	
	public List<SupportByClaim> getClaim_claim_links();
	
	public List<SupportByInference> getClaim_inference_links();
	
	public List<SafetyCase> getSub_cases();
	
	public List<ContextOf> getContext_links();
	
}
