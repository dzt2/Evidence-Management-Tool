package cn.edu.buaa.sei.logicAC.meta.common.expr;

/**
 * FixedOperator is an Operator with fixed number of operands.<br>
 * The fixed number can be config while not changed after it is constructed.<br>
 * 1) UnaryOperator 2) BinaryOperator 3) MultipleOperator <br>
 * MultipleOperator can be configed with its fixed number [named dimension]
 * */
public interface FixedOperator extends Operator{
	/**
	 * Return the fixed number of operands.<br>
	 * The number of operands must be just equal to the dimension.<br>
	 * 1) UnaryOperator: return 1<br>
	 * 2) BinaryOperator: return 2<br>
	 * 3) MultipleOperator: return n {user-defined}
	 * */
	public int dimension();
}
