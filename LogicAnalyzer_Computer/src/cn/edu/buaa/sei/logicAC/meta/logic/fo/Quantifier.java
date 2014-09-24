package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Expression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

/**
 * <b>Q(domain,scope)</b><br>
 * Quantifier is an Expression so to be context-independent {at least in the own level of computation}<br>
 * Quantifier is a LogicFormulation so to be used in other LogicExpression...
 * */
public interface Quantifier extends Expression,LogicFormulation{
	/**
	 * Quantifier contains QuantifierOperator as its operator.
	 * */
	public QuantifierOperator getOperator();
}
