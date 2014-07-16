package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SupportByClaimImpl extends ManagedObjectImpl implements SupportByClaim {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SupportByClaimImpl() {
		super(LMFContext.typeForName(SupportByClaim.TYPE_NAME));
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
	public ImplClaim getConclusion() {
		return (ImplClaim) get(SupportByClaim.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(ImplClaim value) {
		set(SupportByClaim.KEY_CONCLUSION, value);
	}
	
}
