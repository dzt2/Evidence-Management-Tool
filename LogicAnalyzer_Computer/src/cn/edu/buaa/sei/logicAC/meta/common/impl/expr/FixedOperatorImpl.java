package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.FixedOperator;

public abstract class FixedOperatorImpl extends OperatorImpl implements FixedOperator{
	FixedOperatorImpl(int dimension) throws Exception{
		super();
		if(dimension<=0)
			throw new Exception("Invalid dimension in constructing FixedOperator: "+dimension);
		
		this.operands = new Computable[dimension];
	}
	
	@Override
	public int dimension() {return this.operands.length;}
	
}
