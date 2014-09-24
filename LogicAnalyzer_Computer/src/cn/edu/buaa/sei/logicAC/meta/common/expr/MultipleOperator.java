package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

/**
 * op(x1,x2,x3...,xn), n is specified by user<br>
 * */
public interface MultipleOperator extends FixedOperator{
	/**
	 * Set the operands with computable list of length n.
	 * @exception Exception operands == null
	 * @exception Exception operands.length != this.dimension
	 * */
	public void setOperands(Computable[] operands) throws Exception;
}
