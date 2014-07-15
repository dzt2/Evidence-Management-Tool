package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ChallengeByClaimImpl extends ManagedObjectImpl implements ChallengeByClaim, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ChallengeByClaimImpl() {
		super(LMFContext.typeForName(ChallengeByClaim.TYPE_NAME));
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(ChallengeByClaim.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(ChallengeByClaim.KEY_SOURCE, value);
	}
	
	@Override
	public Claim getPremise() {
		return (Claim) get(ChallengeByClaim.KEY_PREMISE);
	}
	
	@Override
	public void setPremise(Claim value) {
		set(ChallengeByClaim.KEY_PREMISE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(ChallengeByClaim.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(ChallengeByClaim.KEY_TARGET, value);
	}
	
	@Override
	public Claim getConclusion() {
		return (Claim) get(ChallengeByClaim.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(Claim value) {
		set(ChallengeByClaim.KEY_CONCLUSION, value);
	}
	
}
