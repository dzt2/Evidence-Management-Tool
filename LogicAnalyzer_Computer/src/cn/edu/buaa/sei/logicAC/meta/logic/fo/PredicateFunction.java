package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextDependFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;

public interface PredicateFunction extends LogicFunction,ContextDependFunction{
	public PredicateTemplate getTemplate();
}
