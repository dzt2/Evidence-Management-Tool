package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PredicateImpl extends ManagedObjectImpl implements Predicate, Bindable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PredicateImpl() {
		super(LMFContext.typeForName(Predicate.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(Predicate.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Predicate.KEY_NAME, value);
	}
	
	@Override
	public Value getValue() {
		return (Value) get(Predicate.KEY_VALUE);
	}
	
	@Override
	public void setValue(Value value) {
		set(Predicate.KEY_VALUE, value);
	}
	
	@Override
	public List<Variable> getVariables() {
		return get(Predicate.KEY_VARIABLES).listContent().toGenericList(Variable.class);
	}
	
}
