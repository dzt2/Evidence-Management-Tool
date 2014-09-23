package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

public interface FlexibleOperator extends Operator{
	public int getCurrentSize();
	
	public void addChild(Computable child) throws Exception;
	public void removeChild(Computable child) throws Exception;
	public boolean containChild(Computable child);
}
