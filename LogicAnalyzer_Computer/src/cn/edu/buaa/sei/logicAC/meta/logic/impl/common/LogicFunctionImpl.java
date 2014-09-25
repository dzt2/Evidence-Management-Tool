package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;

public abstract class LogicFunctionImpl extends LogicFormulationImpl implements LogicFunction{
	LogicFunctionTemplate template;
	
	protected LogicFunctionImpl(LogicFunctionTemplate template) throws Exception{
		if(template==null)
			throw new Exception("Null template is invalid");
		this.template=template;
	}
	
	@Override
	public LogicFunctionTemplate getTemplate() {return this.template;}

}
