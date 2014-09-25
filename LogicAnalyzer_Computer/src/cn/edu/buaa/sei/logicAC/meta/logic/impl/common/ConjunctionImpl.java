package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Conjunction;

public class ConjunctionImpl extends LogicOperatorImpl implements Conjunction{
	@Override
	public void setOperands(LogicFormulation[] operands) throws Exception {
		if(operands==null)
			throw new Exception("Null operands is invalid");
		if(operands.length<2)
			throw new Exception("Conjunction requires at least 2 operands");
		this.operands=operands;
	}

	@Override
	public LogicFormulation[] getOperands() {return this.operands;}

}
