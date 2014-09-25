package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Equivalence;

public class EquivalenceImpl extends FixedLogicOperatorImpl implements Equivalence{

	protected EquivalenceImpl() throws Exception {super(2);}

	@Override
	public void setOperands(Computable left, Computable right) throws Exception {
		if(left==null||right==null)
			throw new Exception("Null left/right operand is invalid");
		if(!(left instanceof LogicFormulation)||!(right instanceof LogicFormulation))
			throw new ClassCastException("Left/Right should be LogicFormulation");
		
		this.operands[0]=(LogicFormulation) left;
		this.operands[1]=(LogicFormulation) right;
	}

	@Override
	public void setOperands(LogicFormulation left, LogicFormulation right) throws Exception {
		if(left==null||right==null)
			throw new Exception("Null left/right operand is invalid");
		
		this.operands[0] = left;
		this.operands[1] = right;
	}
	

}
