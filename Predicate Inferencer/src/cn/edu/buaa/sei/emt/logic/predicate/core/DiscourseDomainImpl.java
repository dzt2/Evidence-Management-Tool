package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class DiscourseDomainImpl extends ManagedObjectImpl implements DiscourseDomain, Bindable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public DiscourseDomainImpl() {
		super(LMFContext.typeForName(DiscourseDomain.TYPE_NAME));
	}
	
	@Override
	public LSet getSet() {
		return (LSet) get(DiscourseDomain.KEY_SET);
	}
	
	@Override
	public void setSet(LSet value) {
		set(DiscourseDomain.KEY_SET, value);
	}
	
	@Override
	public String getName() {
		return get(DiscourseDomain.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(DiscourseDomain.KEY_NAME, value);
	}
	
	@Override
	public Value getValue() {
		return (Value) get(DiscourseDomain.KEY_VALUE);
	}
	
	@Override
	public void setValue(Value value) {
		set(DiscourseDomain.KEY_VALUE, value);
	}
	
}
