package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.Parameter;

public interface SinglePredicate extends PredicateFunction{
	public Parameter getParameter();
	public void setParameter(Parameter parameter);
}
