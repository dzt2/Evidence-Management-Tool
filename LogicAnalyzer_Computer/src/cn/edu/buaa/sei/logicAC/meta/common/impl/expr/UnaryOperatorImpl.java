package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.UnaryOperator;

public abstract class UnaryOperatorImpl extends FixedOperatorImpl implements UnaryOperator{

	UnaryOperatorImpl() throws Exception {super(1);}

	@Override
	public void setOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new NullPointerException("Null operand is invalid in operator");
		this.operands[0]=operand;
	}

	@Override
	public Computable getOperand() {return this.operands[0];}

}
