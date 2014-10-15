package cn.edu.buaa.sei.SVI.struct.group;

import cn.edu.buaa.sei.SVI.struct.core.expression.FlexibleOperator;
import cn.edu.buaa.sei.SVI.struct.core.extend.GroupStruct;

/**
 * CartesianProduct is a <i>GroupOperator</i> that produce Cartesian Product for sequence of Groups.
 * */
public interface CartesianProduct extends GroupOperator,FlexibleOperator{
	
	/**
	 * _Tuple presents the tuple in Cartesian Product {as its element}.
	 * */
	public static class _Tuple {
		Object[] tuple;
		public void set(Object[] tuple){this.tuple=tuple;}
		public Object[] get(){return this.tuple;}
	}
	
	/**
	 * Return all the operands in operator. Each operand is a Struct so to be interpreted further.
	 * */
	public GroupStruct[] getOperands();
	/**
	 * Set the operands of the operator with any length.
	 * @exception Exception operands==null
	 * @exception Exception operands.contain(null)
	 * */
	public void setOperands(GroupStruct[] operands) throws Exception;
}
