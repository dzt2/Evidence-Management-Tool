package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ClaimImpl extends ManagedObjectImpl implements Claim, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ClaimImpl() {
		super(LMFContext.typeForName(Claim.TYPE_NAME));
	}
	
	@Override
	public String getStatement() {
		return get(Claim.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(Claim.KEY_STATEMENT, value);
	}
	
	@Override
	public boolean getResult() {
		return get(Claim.KEY_RESULT).boolValue();
	}
	
	@Override
	public void setResult(boolean value) {
		set(Claim.KEY_RESULT, value);
	}
	
	@Override
	public boolean getAssured_result() {
		return get(Claim.KEY_ASSURED_RESULT).boolValue();
	}
	
	@Override
	public void setAssured_result(boolean value) {
		set(Claim.KEY_ASSURED_RESULT, value);
	}
	
	@Override
	public String getName() {
		return get(Claim.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Claim.KEY_NAME, value);
	}
	
}
