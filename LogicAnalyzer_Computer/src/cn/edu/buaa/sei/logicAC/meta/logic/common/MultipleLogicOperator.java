package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.expr.MultipleOperator;

public interface MultipleLogicOperator extends FixedLogicOperator,MultipleOperator{
	/**
	 * Set the operands with computable list of length n.
	 * @exception Exception operands == null
	 * @exception Exception operands.length != this.dimension
	 * @exception Exception operands[i] not instance of LogicFormulation
	 * */
	public void setOperands(LogicFormulation[] operands) throws Exception;
}
