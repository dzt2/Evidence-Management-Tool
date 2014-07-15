package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SupportByClaimImpl extends ManagedObjectImpl implements SupportByClaim, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SupportByClaimImpl() {
		super(LMFContext.typeForName(SupportByClaim.TYPE_NAME));
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(SupportByClaim.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(SupportByClaim.KEY_SOURCE, value);
	}
	
	@Override
	public Claim getPremise() {
		return (Claim) get(SupportByClaim.KEY_PREMISE);
	}
	
	@Override
	public void setPremise(Claim value) {
		set(SupportByClaim.KEY_PREMISE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(SupportByClaim.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(SupportByClaim.KEY_TARGET, value);
	}
	
	@Override
	public Claim getConclusion() {
		return (Claim) get(SupportByClaim.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(Claim value) {
		set(SupportByClaim.KEY_CONCLUSION, value);
	}
	
}
