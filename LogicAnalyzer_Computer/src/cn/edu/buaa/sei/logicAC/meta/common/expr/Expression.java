package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;
import cn.edu.buaa.sei.logicAC.meta.common.core.StructuralComputable;

/**
 * Expression is a context-independent computable, whose result only depends on its children 
 * computable and the operator.<br>
 * Expression is a structural computable with children computable in its operator. <br>
 * Expression --> StructuralComputable<br> Operator --> Template.
 * */
public interface Expression extends ContextFreeComputable,StructuralComputable{
	/**
	 * Return the operator of the expression.<br>
	 * Each expression has one and only one operator
	 * */
	public Operator getOperator();
	/**
	 * Return the template of the expression. <br>
	 * The template of expression is just a Operator.
	 * */
	public Operator getTemplate();
}
