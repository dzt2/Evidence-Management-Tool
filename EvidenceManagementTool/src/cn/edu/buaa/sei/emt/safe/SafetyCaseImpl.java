package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SafetyCaseImpl extends ManagedObjectImpl implements SafetyCase, SModule {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SafetyCaseImpl() {
		super(LMFContext.typeForName(SafetyCase.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SafetyCase.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public List<ImplClaim> getImplClaims() {
		return get(SafetyCase.KEY_IMPLCLAIMS).listContent().toGenericList(ImplClaim.class);
	}
	
	@Override
	public List<InferenceSupportByClaim> getInference_claim_links() {
		return get(SafetyCase.KEY_INFERENCE_CLAIM_LINKS).listContent().toGenericList(InferenceSupportByClaim.class);
	}
	
	@Override
	public List<Inference> getInferences() {
		return get(SafetyCase.KEY_INFERENCES).listContent().toGenericList(Inference.class);
	}
	
	@Override
	public List<SupportByEvidence> getClaim_evidence_links() {
		return get(SafetyCase.KEY_CLAIM_EVIDENCE_LINKS).listContent().toGenericList(SupportByEvidence.class);
	}
	
	@Override
	public List<AssumedBy> getAssumption_links() {
		return get(SafetyCase.KEY_ASSUMPTION_LINKS).listContent().toGenericList(AssumedBy.class);
	}
	
	@Override
	public String getId() {
		return get(SafetyCase.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SafetyCase.KEY_ID, value);
	}
	
	@Override
	public List<SModule> getSubModules() {
		return get(SafetyCase.KEY_SUBMODULES).listContent().toGenericList(SModule.class);
	}
	
	@Override
	public List<UndevClaim> getUndevClaims() {
		return get(SafetyCase.KEY_UNDEVCLAIMS).listContent().toGenericList(UndevClaim.class);
	}
	
	@Override
	public List<SRelation> getRelations() {
		return get(SafetyCase.KEY_RELATIONS).listContent().toGenericList(SRelation.class);
	}
	
	@Override
	public List<SNode> getNodes() {
		return get(SafetyCase.KEY_NODES).listContent().toGenericList(SNode.class);
	}
	
	@Override
	public String getName() {
		return get(SafetyCase.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(SafetyCase.KEY_NAME, value);
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
	public String getGid() {
		return get(SafetyCase.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SafetyCase.KEY_GID, value);
	}
	
	@Override
	public List<EvidenceRef> getEvidenceRefs() {
		return get(SafetyCase.KEY_EVIDENCEREFS).listContent().toGenericList(EvidenceRef.class);
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
	public List<Annotation> getAnnotations() {
		return get(SafetyCase.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<SupportByClaim> getClaim_claim_links() {
		return get(SafetyCase.KEY_CLAIM_CLAIM_LINKS).listContent().toGenericList(SupportByClaim.class);
	}
	
	@Override
	public List<SupportByInference> getClaim_inference_links() {
		return get(SafetyCase.KEY_CLAIM_INFERENCE_LINKS).listContent().toGenericList(SupportByInference.class);
	}
	
	@Override
	public List<SafetyCase> getSub_cases() {
		return get(SafetyCase.KEY_SUB_CASES).listContent().toGenericList(SafetyCase.class);
	}
	
	@Override
	public List<UndevClaim> getSupport_undev_claims() {
		return get(SafetyCase.KEY_SUPPORT_UNDEV_CLAIMS).listContent().toGenericList(UndevClaim.class);
	}
	
	@Override
	public List<ContextOf> getContext_links() {
		return get(SafetyCase.KEY_CONTEXT_LINKS).listContent().toGenericList(ContextOf.class);
	}
	
}
