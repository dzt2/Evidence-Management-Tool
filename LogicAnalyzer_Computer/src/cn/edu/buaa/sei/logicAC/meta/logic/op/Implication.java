package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.logic.common.BinaryLogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

/**
 * <b>X --> Y</b><br>
 * Implication is a BinaryOpeartor with both operands: precondition & conclusion<br>
 * Implication is a LogicOperator used in LogicExpression
 * */
public interface Implication extends BinaryLogicOperator{
	/**
	 * Return the precondition of the implication operator
	 * */
	public LogicFormulation getPrecondition();
	/**
	 * Return the conclusion of the implication operator
	 * */
	public LogicFormulation getConclusion();
}
