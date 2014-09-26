package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.FixedLogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public abstract class FixedLogicOperatorImpl extends LogicOperatorImpl implements FixedLogicOperator{
	
	protected FixedLogicOperatorImpl(int dimension) throws Exception{
		if(dimension<=0)
			throw new Exception("Invalid dimension to construct FixedLogicOperator: "+dimension);
		this.operands = new LogicFormulation[dimension];
	}

	@Override
	public int dimension() {return this.operands.length;}

}
