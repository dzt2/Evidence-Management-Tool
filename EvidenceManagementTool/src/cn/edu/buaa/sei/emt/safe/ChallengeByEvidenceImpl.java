package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ChallengeByEvidenceImpl extends ManagedObjectImpl implements ChallengeByEvidence, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ChallengeByEvidenceImpl() {
		super(LMFContext.typeForName(ChallengeByEvidence.TYPE_NAME));
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(ChallengeByEvidence.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(ChallengeByEvidence.KEY_OBJECTIVE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(ChallengeByEvidence.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(ChallengeByEvidence.KEY_SOURCE, value);
	}
	
	@Override
	public EvidenceElement getEvidence() {
		return (EvidenceElement) get(ChallengeByEvidence.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(EvidenceElement value) {
		set(ChallengeByEvidence.KEY_EVIDENCE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(ChallengeByEvidence.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(ChallengeByEvidence.KEY_TARGET, value);
	}
	
}
