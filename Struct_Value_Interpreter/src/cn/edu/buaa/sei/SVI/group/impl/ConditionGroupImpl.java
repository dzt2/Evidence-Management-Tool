package cn.edu.buaa.sei.SVI.group.impl;

import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.core.variable.impl.VariableFactory;
import cn.edu.buaa.sei.SVI.group.ConditionGroup;
import cn.edu.buaa.sei.SVI.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.logic.impl.LogicFactory;

/**
 * <i>ConditionGroupImpl</i> is abstract for some methods in it need to be confirmed in specialized context. 
 * For example, size() and contains() requires the inference computer involved. 
 * */
public abstract class ConditionGroupImpl implements ConditionGroup{
	
	LogicFunction function;
	Variable iter = VariableFactory.createFreeVariable("iter");
	
	/**
	 * Format: {x|P(x)} ==> P(iter), iter = x
	 * */
	ConditionGroupImpl()throws Exception{
		LogicFunctionTemplate template = LogicFactory.createLogicFunctionTemplate("P", new Variable[]{iter});
		this.function=LogicFactory.createLogicFunction(template);
	}

	@Override
	public LogicFunction getCondition() {return this.function;}
	@Override
	public Variable getVariable() {return this.iter;}

}
