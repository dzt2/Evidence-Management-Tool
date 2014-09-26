package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;

public abstract class BinaryOperatorImpl extends FixedOperatorImpl implements BinaryOperator{

	BinaryOperatorImpl() throws Exception {super(2);}

	@Override
	public void setOperands(Computable left, Computable right) throws Exception {
		if(left==null||right==null)
			throw new NullPointerException("Operands in BinaryOperator should not be Null");
		this.operands[0]=left;
		this.operands[1]=right;
	}

	@Override
	public Computable getLeft() {return this.operands[0];}

	@Override
	public Computable getRight() {return this.operands[1];}
	
	

}
