package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

public interface MultipleOperator extends FixedOperator{
	public void setChildren(Computable[] children) throws Exception;
}
