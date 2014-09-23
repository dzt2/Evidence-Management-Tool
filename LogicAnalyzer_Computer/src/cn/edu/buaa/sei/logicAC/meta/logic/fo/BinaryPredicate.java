package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.Parameter;

public interface BinaryPredicate extends PredicateFunction{
	public Parameter[] getBothParameter();
	public void setBothParameter(Parameter p1,Parameter p2);
	
	public boolean isDirected();
	public void setDirected(boolean direct);
}
