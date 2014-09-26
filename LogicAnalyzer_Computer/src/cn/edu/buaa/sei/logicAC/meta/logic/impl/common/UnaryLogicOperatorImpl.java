package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.UnaryLogicOperator;

public abstract class UnaryLogicOperatorImpl extends FixedLogicOperatorImpl implements UnaryLogicOperator{

	protected UnaryLogicOperatorImpl() throws Exception {super(1);}

	@Override
	public void setOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		if(!(operand instanceof LogicFormulation))
			throw new Exception("Invalid type: "+operand.getClass().getName()+" should be LogicFormulation");
		
		this.setOperand((LogicFormulation)operand);
	}

	@Override
	public void setOperand(LogicFormulation operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		this.operands[0]=operand;
	}

	@Override
	public LogicFormulation getOperand() {return this.operands[0];}

}
