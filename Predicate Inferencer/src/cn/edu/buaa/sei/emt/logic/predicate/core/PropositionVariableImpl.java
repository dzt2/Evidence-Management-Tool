package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PropositionVariableImpl extends ManagedObjectImpl implements PropositionVariable, AtomFormulation, Variable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PropositionVariableImpl() {
		super(LMFContext.typeForName(PropositionVariable.TYPE_NAME));
	}
	
	@Override
	public BooleanObject getT_value() {
		return (BooleanObject) get(PropositionVariable.KEY_T_VALUE);
	}
	
	@Override
	public void setT_value(BooleanObject value) {
		set(PropositionVariable.KEY_T_VALUE, value);
	}
	
	@Override
	public String getName() {
		return get(PropositionVariable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(PropositionVariable.KEY_NAME, value);
	}
	
	@Override
	public Value getValue() {
		return (Value) get(PropositionVariable.KEY_VALUE);
	}
	
	@Override
	public void setValue(Value value) {
		set(PropositionVariable.KEY_VALUE, value);
	}
	
	@Override
	public LObject getObject() {
		return (LObject) get(PropositionVariable.KEY_OBJECT);
	}
	
	@Override
	public void setObject(LObject value) {
		set(PropositionVariable.KEY_OBJECT, value);
	}
	
}
