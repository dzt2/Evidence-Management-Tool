package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.context.MapRunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSetVariable;

public class PredicateFunctionEnvironmentImpl extends MapRunnerEnvironment implements PredicateFunctionEnvironment{
	protected PredicateFunctionEnvironmentImpl(Context context,RunnerEnvironment parent) throws Exception {
		super(context, parent);
		Variable var = new RelationSetVariableImpl(RELATION);
		this.appendVariable(var);
	}

	@Override
	public RelationSetVariable getRelationSetVariable() {
		try {
			return (RelationSetVariable) this.getVariable(RELATION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
