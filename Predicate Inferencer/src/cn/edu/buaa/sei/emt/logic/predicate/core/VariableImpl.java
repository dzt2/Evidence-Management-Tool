package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class VariableImpl extends ManagedObjectImpl implements Variable, Bindable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public VariableImpl() {
		super(LMFContext.typeForName(Variable.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(Variable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Variable.KEY_NAME, value);
	}
	
	@Override
	public Value getValue() {
		return (Value) get(Variable.KEY_VALUE);
	}
	
	@Override
	public void setValue(Value value) {
		set(Variable.KEY_VALUE, value);
	}
	
	@Override
	public LObject getObject() {
		return (LObject) get(Variable.KEY_OBJECT);
	}
	
	@Override
	public void setObject(LObject value) {
		set(Variable.KEY_OBJECT, value);
	}
	
}
