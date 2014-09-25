package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;

public abstract class OperatorImpl implements Operator{
	protected Computable[] operands;
	@Override
	public Computable[] getOperands() {return this.operands;}

}
