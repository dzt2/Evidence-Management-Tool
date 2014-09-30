package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;

public interface PredicateFunctionEnvironment extends RunnerEnvironment{
	public static final String RELATION = "_relation";
	
	public RelationSetVariable getRelationSetVariable();
}
