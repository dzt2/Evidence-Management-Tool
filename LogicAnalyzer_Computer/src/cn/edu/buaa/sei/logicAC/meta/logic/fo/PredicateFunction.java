package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextDependFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;

/**
 * PredicateFunction is the LogicFunction in First-Order Logic Theory.
 * */
public interface PredicateFunction extends LogicFunction,ContextDependFunction{
	/**
	 * PredicateFunction use PredicateTemplate as its template.
	 * */
	public PredicateTemplate getTemplate();
}
