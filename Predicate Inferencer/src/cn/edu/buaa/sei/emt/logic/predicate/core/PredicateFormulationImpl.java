package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PredicateFormulationImpl extends ManagedObjectImpl implements PredicateFormulation, AtomFormulation, Bindable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PredicateFormulationImpl() {
		super(LMFContext.typeForName(PredicateFormulation.TYPE_NAME));
	}
	
	@Override
	public List<Variable> getArguments() {
		return get(PredicateFormulation.KEY_ARGUMENTS).listContent().toGenericList(Variable.class);
	}
	
	@Override
	public String getName() {
		return get(PredicateFormulation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(PredicateFormulation.KEY_NAME, value);
	}
	
	@Override
	public Value getValue() {
		return (Value) get(PredicateFormulation.KEY_VALUE);
	}
	
	@Override
	public void setValue(Value value) {
		set(PredicateFormulation.KEY_VALUE, value);
	}
	
	@Override
	public List<Variable> getVariables() {
		return get(PredicateFormulation.KEY_VARIABLES).listContent().toGenericList(Variable.class);
	}
	
}
