package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SafetyCaseImpl extends ManagedObjectImpl implements SafetyCase {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SafetyCaseImpl() {
		super(LMFContext.typeForName(SafetyCase.TYPE_NAME));
	}
	
	@Override
	public List<Claim> getClaims() {
		return get(SafetyCase.KEY_CLAIMS).listContent().toGenericList(Claim.class);
	}
	
	@Override
	public List<SupportByClaim> getClaim_supports() {
		return get(SafetyCase.KEY_CLAIM_SUPPORTS).listContent().toGenericList(SupportByClaim.class);
	}
	
	@Override
	public List<SupportByEvidence> getEvidence_supports() {
		return get(SafetyCase.KEY_EVIDENCE_SUPPORTS).listContent().toGenericList(SupportByEvidence.class);
	}
	
	@Override
	public List<SafetyCase> getSafetycaseReferences() {
		return get(SafetyCase.KEY_SAFETYCASEREFERENCES).listContent().toGenericList(SafetyCase.class);
	}
	
	@Override
	public List<ChallengeByClaim> getClaim_challenges() {
		return get(SafetyCase.KEY_CLAIM_CHALLENGES).listContent().toGenericList(ChallengeByClaim.class);
	}
	
	@Override
	public List<ChallengeByEvidence> getEvidence_challenges() {
		return get(SafetyCase.KEY_EVIDENCE_CHALLENGES).listContent().toGenericList(ChallengeByEvidence.class);
	}
	
	@Override
	public List<AssumedBy> getAssumption_links() {
		return get(SafetyCase.KEY_ASSUMPTION_LINKS).listContent().toGenericList(AssumedBy.class);
	}
	
	@Override
	public Claim getTop_goal() {
		return (Claim) get(SafetyCase.KEY_TOP_GOAL);
	}
	
	@Override
	public void setTop_goal(Claim value) {
		set(SafetyCase.KEY_TOP_GOAL, value);
	}
	
	@Override
	public List<JustifiedBy> getJustification_links() {
		return get(SafetyCase.KEY_JUSTIFICATION_LINKS).listContent().toGenericList(JustifiedBy.class);
	}
	
	@Override
	public List<Assumption> getAssumptions() {
		return get(SafetyCase.KEY_ASSUMPTIONS).listContent().toGenericList(Assumption.class);
	}
	
	@Override
	public List<Claim> getExtandable_claims() {
		return get(SafetyCase.KEY_EXTANDABLE_CLAIMS).listContent().toGenericList(Claim.class);
	}
	
	@Override
	public List<Justification> getJustifications() {
		return get(SafetyCase.KEY_JUSTIFICATIONS).listContent().toGenericList(Justification.class);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(SafetyCase.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public List<EvidenceReference> getEvidences() {
		return get(SafetyCase.KEY_EVIDENCES).listContent().toGenericList(EvidenceReference.class);
	}
	
	@Override
	public List<ContextOf> getContext_links() {
		return get(SafetyCase.KEY_CONTEXT_LINKS).listContent().toGenericList(ContextOf.class);
	}
	
}
