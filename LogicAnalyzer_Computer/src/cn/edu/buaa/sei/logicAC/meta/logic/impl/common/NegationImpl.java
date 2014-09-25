package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Negation;

public class NegationImpl extends FixedLogicOperatorImpl implements Negation{

	protected NegationImpl() throws Exception {super(1);}

	@Override
	public void setOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		if(!(operand instanceof LogicFormulation))
			throw new ClassCastException("Operand should be LogicFormulation");
		this.operands[0]=(LogicFormulation) operand;
	}

	@Override
	public void setOperand(LogicFormulation operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		this.operands[0]=(LogicFormulation) operand;
	}

}
