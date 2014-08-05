package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EquivalenceImpl extends ManagedObjectImpl implements Equivalence, LogicOperator {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EquivalenceImpl() {
		super(LMFContext.typeForName(Equivalence.TYPE_NAME));
	}
	
	@Override
	public LogicFormulation getFormulation1() {
		return (LogicFormulation) get(Equivalence.KEY_FORMULATION1);
	}
	
	@Override
	public void setFormulation1(LogicFormulation value) {
		set(Equivalence.KEY_FORMULATION1, value);
	}
	
	@Override
	public LogicFormulation getFormulation2() {
		return (LogicFormulation) get(Equivalence.KEY_FORMULATION2);
	}
	
	@Override
	public void setFormulation2(LogicFormulation value) {
		set(Equivalence.KEY_FORMULATION2, value);
	}
	
}
