package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

/**
 * <b>X --> Y</b><br>
 * Implication is a BinaryOpeartor with both operands: precondition & conclusion<br>
 * Implication is a LogicOperator used in LogicExpression
 * */
public interface Implication extends LogicOperator,BinaryOperator{
	/**
	 * Set the both operands in Implication.
	 * */
	public void setOperands(LogicFormulation precondition,LogicFormulation conclusion) throws Exception;
}
