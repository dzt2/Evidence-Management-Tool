package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ImplicationImpl extends ManagedObjectImpl implements Implication, LogicOperator {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ImplicationImpl() {
		super(LMFContext.typeForName(Implication.TYPE_NAME));
	}
	
	@Override
	public LogicFormulation getPremise() {
		return (LogicFormulation) get(Implication.KEY_PREMISE);
	}
	
	@Override
	public void setPremise(LogicFormulation value) {
		set(Implication.KEY_PREMISE, value);
	}
	
	@Override
	public LogicFormulation getConclusion() {
		return (LogicFormulation) get(Implication.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(LogicFormulation value) {
		set(Implication.KEY_CONCLUSION, value);
	}
	
}
