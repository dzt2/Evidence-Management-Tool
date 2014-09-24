package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.BinaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

/**
 * <b>X <--> Y</b><br>
 * Equivalence is LogicOperator used in LogicExpression.<br>
 * Equivalence is BinaryOperator with two operands: left & right
 * 
 * */
public interface Equivalence extends LogicOperator,BinaryOperator{
	/**
	 * Set the both operands in Equivalence.
	 * */
	public void setOperands(LogicFormulation left,LogicFormulation right) throws Exception;
}
