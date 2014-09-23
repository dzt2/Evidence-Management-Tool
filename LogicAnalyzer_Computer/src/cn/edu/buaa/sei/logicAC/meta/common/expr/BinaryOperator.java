package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

public interface BinaryOperator extends FixedOperator{
	public void setChildren(Computable left,Computable right) throws Exception;
}
