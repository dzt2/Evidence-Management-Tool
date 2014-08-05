package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class UniversalImpl extends ManagedObjectImpl implements Universal, Quantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public UniversalImpl() {
		super(LMFContext.typeForName(Universal.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(Universal.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Universal.KEY_NAME, value);
	}
	
	@Override
	public LogicFormulation getScope_formulation() {
		return (LogicFormulation) get(Universal.KEY_SCOPE_FORMULATION);
	}
	
	@Override
	public void setScope_formulation(LogicFormulation value) {
		set(Universal.KEY_SCOPE_FORMULATION, value);
	}
	
	@Override
	public DiscourseDomain getDomain() {
		return (DiscourseDomain) get(Universal.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(DiscourseDomain value) {
		set(Universal.KEY_DOMAIN, value);
	}
	
}
