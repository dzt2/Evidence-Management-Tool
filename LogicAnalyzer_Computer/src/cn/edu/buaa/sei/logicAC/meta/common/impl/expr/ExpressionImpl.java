package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Expression;
import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;

public abstract class ExpressionImpl implements Expression{
	Object result;
	Operator op;
	
	ExpressionImpl(Operator op) throws Exception{
		if(op==null)
			throw new NullPointerException("Null operator cannot composite an expression");
		this.op=op;
	}
	
	
	@Override
	public Object getResult() {return this.result;}

	@Override
	public void setResult(Object result) {this.result=result;}

	@Override
	public Operator getOperator() {return this.op;}

	@Override
	public Operator getTemplate() {return this.op;}

}
