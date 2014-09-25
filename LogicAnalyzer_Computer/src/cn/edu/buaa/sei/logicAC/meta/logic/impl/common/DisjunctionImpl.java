package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Disjunction;

public class DisjunctionImpl extends LogicOperatorImpl implements Disjunction{
	
	@Override
	public void setOperands(LogicFormulation[] operands) throws Exception {
		if(operands==null)
			throw new Exception("Null operands is invalid");
		if(operands.length<2)
			throw new Exception("Disjunction requires at least 2 operands");
		this.operands=operands;
	}

}
