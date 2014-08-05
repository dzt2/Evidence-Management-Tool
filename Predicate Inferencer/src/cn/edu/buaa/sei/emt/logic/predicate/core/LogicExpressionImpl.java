package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class LogicExpressionImpl extends ManagedObjectImpl implements LogicExpression, LogicFormulation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public LogicExpressionImpl() {
		super(LMFContext.typeForName(LogicExpression.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(LogicExpression.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(LogicExpression.KEY_NAME, value);
	}
	
	@Override
	public LogicOperator getOperator() {
		return (LogicOperator) get(LogicExpression.KEY_OPERATOR);
	}
	
	@Override
	public void setOperator(LogicOperator value) {
		set(LogicExpression.KEY_OPERATOR, value);
	}
	
}
