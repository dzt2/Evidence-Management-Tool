package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SupportByEvidenceImpl extends ManagedObjectImpl implements SupportByEvidence, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SupportByEvidenceImpl() {
		super(LMFContext.typeForName(SupportByEvidence.TYPE_NAME));
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(SupportByEvidence.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(SupportByEvidence.KEY_OBJECTIVE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(SupportByEvidence.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(SupportByEvidence.KEY_SOURCE, value);
	}
	
	@Override
	public EvidenceElement getEvidence() {
		return (EvidenceElement) get(SupportByEvidence.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(EvidenceElement value) {
		set(SupportByEvidence.KEY_EVIDENCE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(SupportByEvidence.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(SupportByEvidence.KEY_TARGET, value);
	}
	
}
