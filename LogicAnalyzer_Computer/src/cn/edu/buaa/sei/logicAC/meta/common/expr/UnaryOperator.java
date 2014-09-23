package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

public interface UnaryOperator extends FixedOperator{
	public void setChild(Computable child) throws Exception;
}
