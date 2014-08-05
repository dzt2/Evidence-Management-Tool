package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ExistentialImpl extends ManagedObjectImpl implements Existential, Quantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ExistentialImpl() {
		super(LMFContext.typeForName(Existential.TYPE_NAME));
	}
	
	@Override
	public List<Variable> getArguments() {
		return get(Existential.KEY_ARGUMENTS).listContent().toGenericList(Variable.class);
	}
	
	@Override
	public String getName() {
		return get(Existential.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Existential.KEY_NAME, value);
	}
	
	@Override
	public LogicFormulation getScope_formulation() {
		return (LogicFormulation) get(Existential.KEY_SCOPE_FORMULATION);
	}
	
	@Override
	public void setScope_formulation(LogicFormulation value) {
		set(Existential.KEY_SCOPE_FORMULATION, value);
	}
	
	@Override
	public DiscourseDomain getDomain() {
		return (DiscourseDomain) get(Existential.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(DiscourseDomain value) {
		set(Existential.KEY_DOMAIN, value);
	}
	
}
