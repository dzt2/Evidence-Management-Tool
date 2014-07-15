package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class UndevelopedClaimImpl extends ManagedObjectImpl implements UndevelopedClaim, Claim {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public UndevelopedClaimImpl() {
		super(LMFContext.typeForName(UndevelopedClaim.TYPE_NAME));
	}
	
	@Override
	public String getStatement() {
		return get(UndevelopedClaim.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(UndevelopedClaim.KEY_STATEMENT, value);
	}
	
	@Override
	public boolean getResult() {
		return get(UndevelopedClaim.KEY_RESULT).boolValue();
	}
	
	@Override
	public void setResult(boolean value) {
		set(UndevelopedClaim.KEY_RESULT, value);
	}
	
	@Override
	public boolean getAssured_result() {
		return get(UndevelopedClaim.KEY_ASSURED_RESULT).boolValue();
	}
	
	@Override
	public void setAssured_result(boolean value) {
		set(UndevelopedClaim.KEY_ASSURED_RESULT, value);
	}
	
	@Override
	public String getName() {
		return get(UndevelopedClaim.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(UndevelopedClaim.KEY_NAME, value);
	}
	
	@Override
	public SafetyCase getCase() {
		return (SafetyCase) get(UndevelopedClaim.KEY_CASE);
	}
	
	@Override
	public void setCase(SafetyCase value) {
		set(UndevelopedClaim.KEY_CASE, value);
	}
	
}
