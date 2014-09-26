package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.BinaryLogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public abstract class BinaryLogicOperatorImpl extends FixedLogicOperatorImpl implements BinaryLogicOperator{

	protected BinaryLogicOperatorImpl() throws Exception {super(2);}

	@Override
	public void setOperands(Computable left, Computable right) throws Exception {
		if(left==null||right==null)
			throw new Exception("Left|Right is null invalid");
		if(!(left instanceof LogicFormulation)||!(right instanceof LogicFormulation))
			throw new Exception("Left|Right should be LogicFormulation");
		
		this.setOperands((LogicFormulation)left, (LogicFormulation)right);
	}

	@Override
	public void setOperands(LogicFormulation left, LogicFormulation right)
			throws Exception {
		if(left==null||right==null)
			throw new Exception("Left|Right is null invalid");
		
		this.operands[0]=left;
		this.operands[1]=right;
	}

	@Override
	public LogicFormulation getLeft() {return this.operands[0];}

	@Override
	public LogicFormulation getRight() {return this.operands[1];}

}
