package cn.edu.buaa.sei.emt.logic.creator;

import java.util.List;

import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class LogicAssigner {
	public static void assignVariable(Variable var,LObject value){
		if(var==null)return;
		var.setValue(value);
		var.setObject(value);
	}
	public static void assignDiscourseDomain(DiscourseDomain domain,LSet set){
		if(domain==null)return;
		domain.setValue(set);
		domain.setSet(set);
	}
	public static void assignPropositionVariable(PropositionVariable var,BooleanObject value){
		if(var==null)return;
		assignVariable(var,value);
		var.setT_value(value);
	}
	public static void assignPredicateVariables(PredicateFormulation var,List<LObject> values){
		if(var==null||values==null||var.getVariables().size()!=values.size())return;
		List<Variable> vars = var.getVariables();
		for(int i=0;i<vars.size();i++)
			assignVariable(vars.get(i),values.get(i));
	}
	public static void assignPredicateFormulation(PredicateFormulation var,LRelationSet value){
		if(var==null||value==null||value.getRelations().size()<1)return;
		var.setValue(value);
		var.setAssociated_relations(value);
	}
	
}
