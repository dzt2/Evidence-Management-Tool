package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.Parameter;

public interface MultiplePredicate extends PredicateFunction{
	public Parameter[] getParameters();
	public void setParameters(Parameter[] parameters);
	public int getParameterSize();
}
