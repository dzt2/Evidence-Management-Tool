package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.core.Template;

/**
 * Operator is a template of expression [as a Structural Computable]<br>
 * Each operator contains a list of operands, and an operand is a computable. <br>
 * 1) Unary Operator: contains only one operand, such as !x<br>
 * 2) Binary Operator: contains two operands, such as x+y<br>
 * 3) Multiple Operator: contains more than two operands, such as x?y:z
 * */
public interface Operator extends Template{
	/**
	 * Return the operands.
	 * */
	public Computable[] getOperands();
}
