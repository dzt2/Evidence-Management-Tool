package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface SafetyCase extends ManagedObject {
	
	public static final String KEY_JUSTIFICATION_LINKS = "justification_links";
	public static final String KEY_ASSUMPTIONS = "assumptions";
	public static final String KEY_ASSUMPTION_LINKS = "assumption_links";
	public static final String KEY_EXTANDABLE_CLAIMS = "extandable_claims";
	public static final String KEY_EVIDENCES = "evidences";
	public static final String TYPE_NAME = "safe.SafetyCase";
	public static final String KEY_TOP_GOAL = "top_goal";
	public static final String KEY_EVIDENCE_CHALLENGES = "evidence_challenges";
	public static final String KEY_CONTEXT_LINKS = "context_links";
	public static final String KEY_CLAIMS = "claims";
	public static final String KEY_JUSTIFICATIONS = "justifications";
	public static final String KEY_SAFETYCASEREFERENCES = "safetycaseReferences";
	public static final String KEY_CLAIM_SUPPORTS = "claim_supports";
	public static final String KEY_CLAIM_CHALLENGES = "claim_challenges";
	public static final String KEY_EVIDENCE_SUPPORTS = "evidence_supports";
	public static final String KEY_CONTEXTS = "contexts";
	
	
	public List<Claim> getClaims();
	
	public List<SupportByClaim> getClaim_supports();
	
	public List<SupportByEvidence> getEvidence_supports();
	
	public List<SafetyCase> getSafetycaseReferences();
	
	public List<ChallengeByClaim> getClaim_challenges();
	
	public List<ChallengeByEvidence> getEvidence_challenges();
	
	public List<AssumedBy> getAssumption_links();
	
	public Claim getTop_goal();
	
	public void setTop_goal(Claim value);
	
	public List<JustifiedBy> getJustification_links();
	
	public List<Assumption> getAssumptions();
	
	public List<Claim> getExtandable_claims();
	
	public List<Justification> getJustifications();
	
	public List<Context> getContexts();
	
	public List<EvidenceReference> getEvidences();
	
	public List<ContextOf> getContext_links();
	
}
