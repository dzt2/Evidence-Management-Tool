package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.ComputedContext;
import cn.edu.buaa.sei.logicAC.meta.common.Expression;
import cn.edu.buaa.sei.logicAC.meta.common.Operator;

/**
 * ExpressionImpl is the common super class for all expression in the system.
 * This class only apply the configuration of operator and context.
 * The computability of the expression depends on the computability of its operator.
 * */
public class ExpressionImpl implements Expression{
	Operator op;
	ComputedContext context;
	
	protected ExpressionImpl(Operator op) throws Exception{
		if(op==null)
			throw new Exception("Null operator could not be applied.");
		this.op=op;
	}

	@Override
	public boolean interpret(ComputedContext context) {
		if(context==null)return false;
		this.context=context;
		this.op.interpret(context);
		return true;
	}

	@Override
	public Operator getOperator() {return this.op;}

}
