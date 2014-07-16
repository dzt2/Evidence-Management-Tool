package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface SupportByClaim extends ManagedObject {
	
	public static final String TYPE_NAME = "safe.SupportByClaim";
	public static final String KEY_PREMISE = "premise";
	public static final String KEY_CONCLUSION = "conclusion";
	
	
	public Claim getPremise();
	
	public void setPremise(Claim value);
	
	public ImplClaim getConclusion();
	
	public void setConclusion(ImplClaim value);
	
}
