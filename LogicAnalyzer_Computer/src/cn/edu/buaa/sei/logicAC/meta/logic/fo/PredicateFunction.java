package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextDependFunction;

public interface PredicateFunction extends ContextDependFunction{
	public void setTemplate(PredicateTemplate template);
	public PredicateTemplate getTemplate();
}
