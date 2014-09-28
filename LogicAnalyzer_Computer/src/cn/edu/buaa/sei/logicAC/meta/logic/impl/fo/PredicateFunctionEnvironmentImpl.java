package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.context.MapRunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSet;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSetVariable;

public class PredicateFunctionEnvironmentImpl extends MapRunnerEnvironment implements PredicateFunctionEnvironment{

	protected PredicateFunctionEnvironmentImpl(Context context,RunnerEnvironment parent) throws Exception {
		super(context, parent);
	}

	@Override
	public void setRelationSetValue(RelationSet value) throws Exception {
		RelationSetVariable var = new RelationSetVariableImpl(RELATION);
		var.assign(value);
	}

	@Override
	public RelationSet getRelationSetValue() {
		if(!this.containVariable(RELATION))return null;
		try {
			Variable var = this.getVariable(RELATION);
			Object val = var.read();
			if(val!=null&&val instanceof RelationSet)
				return (RelationSet) val;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
