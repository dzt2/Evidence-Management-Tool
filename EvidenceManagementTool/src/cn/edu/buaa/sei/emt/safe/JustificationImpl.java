package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class JustificationImpl extends ManagedObjectImpl implements Justification, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public JustificationImpl() {
		super(LMFContext.typeForName(Justification.TYPE_NAME));
	}
	
	@Override
	public String getStatement() {
		return get(Justification.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(Justification.KEY_STATEMENT, value);
	}
	
	@Override
	public boolean getResult() {
		return get(Justification.KEY_RESULT).boolValue();
	}
	
	@Override
	public void setResult(boolean value) {
		set(Justification.KEY_RESULT, value);
	}
	
	@Override
	public boolean getAssured_result() {
		return get(Justification.KEY_ASSURED_RESULT).boolValue();
	}
	
	@Override
	public void setAssured_result(boolean value) {
		set(Justification.KEY_ASSURED_RESULT, value);
	}
	
	@Override
	public String getName() {
		return get(Justification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Justification.KEY_NAME, value);
	}
	
}
