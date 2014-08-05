package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class NegationImpl extends ManagedObjectImpl implements Negation, LogicOperator {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public NegationImpl() {
		super(LMFContext.typeForName(Negation.TYPE_NAME));
	}
	
	@Override
	public LogicFormulation getFormulation() {
		return (LogicFormulation) get(Negation.KEY_FORMULATION);
	}
	
	@Override
	public void setFormulation(LogicFormulation value) {
		set(Negation.KEY_FORMULATION, value);
	}
	
}
