package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssumptionImpl extends ManagedObjectImpl implements Assumption, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssumptionImpl() {
		super(LMFContext.typeForName(Assumption.TYPE_NAME));
	}
	
	@Override
	public String getStatement() {
		return get(Assumption.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(Assumption.KEY_STATEMENT, value);
	}
	
	@Override
	public boolean getResult() {
		return get(Assumption.KEY_RESULT).boolValue();
	}
	
	@Override
	public void setResult(boolean value) {
		set(Assumption.KEY_RESULT, value);
	}
	
	@Override
	public boolean getAssured_result() {
		return get(Assumption.KEY_ASSURED_RESULT).boolValue();
	}
	
	@Override
	public void setAssured_result(boolean value) {
		set(Assumption.KEY_ASSURED_RESULT, value);
	}
	
	@Override
	public String getName() {
		return get(Assumption.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Assumption.KEY_NAME, value);
	}
	
}
