package cn.edu.buaa.sei.logicAC.meta.logic.op;

import cn.edu.buaa.sei.logicAC.meta.common.expr.UnaryOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;

/**
 * <b>Not x</b> <br>
 * Negation is a general LogicOperator used in logic computation.<br>
 * Negation is a UnaryOperator with exactly one LogicFormulation as its operand.
 * */
public interface Negation extends LogicOperator,UnaryOperator{
	/**
	 * Set the only one operand in Negation.
	 * */
	public void setOperand(LogicFormulation operand);
}
