package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.context.MapRunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;

public class PredicateFunctionEnvironmentImpl extends MapRunnerEnvironment implements PredicateFunctionEnvironment{
	protected PredicateFunctionEnvironmentImpl(Context context,RunnerEnvironment parent) throws Exception {
		super(context, parent);
		Variable var = new RelationSetVariableImpl(RELATION);
		this.appendVariable(var);
	}
}
