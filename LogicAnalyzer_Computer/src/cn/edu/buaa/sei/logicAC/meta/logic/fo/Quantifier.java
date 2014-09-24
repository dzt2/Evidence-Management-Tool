package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.function.ContextFreeFunction;

public interface Quantifier extends ContextFreeFunction{
	public void setTemplate(QuantifierTemplate templtate) throws Exception;
	public QuantifierTemplate getTemplate();
}
