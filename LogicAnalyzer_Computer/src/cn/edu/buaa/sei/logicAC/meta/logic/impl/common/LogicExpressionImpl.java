package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicExpression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

public class LogicExpressionImpl extends LogicFormulationImpl implements LogicExpression{
	LogicOperator operator;
	
	LogicExpressionImpl(LogicOperator op) throws Exception{
		if(op==null)
			throw new Exception("Null operator is invalid");
		this.operator=op;
	}
	@Override
	public Operator getTemplate() {return this.operator;}
	@Override
	public LogicOperator getOperator() {return this.operator;}

}
