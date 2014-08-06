package cn.edu.buaa.sei.emt.logic.predicate.compute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Disjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Equivalence;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.Implication;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicOperator;
import cn.edu.buaa.sei.emt.logic.predicate.core.Negation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class LogicInferencer {
	LogicFormulation formulation;
	VariableAnalyzier analyzer = new VariableAnalyzier();
	LRelationSetSearcher searcher = new LRelationSetSearcher();
	
	public LogicInferencer(){}
	
	/*
	 *	Getter & Setter 
	 */
	public LogicFormulation getFormulation(){return this.formulation;}
	public void setFormulation(LogicFormulation form){
		this.formulation=form;
		this.analyzer.setFormulation(this.formulation);
	}

	/*
	 * 	Verification Functions
	 */
	public Set<Bindable> getVariables(){return this.analyzer.getExternalVariables();}
	public boolean isReady(){
		Set<Bindable> vars = this.analyzer.getExternalVariables();
		for(Bindable var:vars){
			if(var instanceof Variable){
				if(var.getValue()==null||((Variable)var).getObject()==null)return false;
			}
			if(var instanceof PropositionVariable){
				if(((PropositionVariable)var).getT_value()==null)return false;
			}
			if(var instanceof DiscourseDomain){
				if(((DiscourseDomain)var).getSet()==null||
				((DiscourseDomain)var).getIter()==null||var.getValue()==null)
					return false;
			}
			if(var instanceof PredicateFormulation){
				PredicateFormulation form = (PredicateFormulation) var;
				if(form.getValue()==null||form.getAssociated_relations()==null)return false;
			}
			
		}
		return true;
	}
	public Set<Bindable> getUnassignedVariable(){
		Set<Bindable> us = new HashSet<Bindable>();
		Set<Bindable> vars = this.analyzer.getExternalVariables();
		for(Bindable var:vars){
			if(var instanceof Variable){
				if(var.getValue()==null||((Variable)var).getObject()==null)
					us.add(var);
			}
			if(var instanceof PropositionVariable){
				if(((PropositionVariable)var).getT_value()==null)
					us.add(var);
			}
			if(var instanceof DiscourseDomain){
				if(((DiscourseDomain)var).getSet()==null||
				((DiscourseDomain)var).getIter()==null||var.getValue()==null)
					us.add(var);
			}
			if(var instanceof PredicateFormulation){
				PredicateFormulation form = (PredicateFormulation) var;
				if(form.getValue()==null||form.getAssociated_relations()==null)
					us.add(var);
			}
			
		}
		return us;
	}

	/*
	 *	Inference Functions
	 *		1. Prepare: verify
	 *		2. Main
	 *		3. Revoking Process
	 */
	boolean prepare_inference(){
		if(!this.isReady())return false;
		searcher.clear();
		Set<Bindable> vars = this.getVariables();
		
		for(Bindable var:vars)
			if(var instanceof LRelationSet)
				searcher.put((LRelationSet) var);
		
		return true;
	}
	void revoke(){
		//...
	}
	
	public Boolean inference(){
		if(!this.prepare_inference())
			return null;
		
		Boolean res = this.inference_formulation(this.formulation);
		
		this.revoke();
		
		return res;
	}
	
	Boolean inference_formulation(LogicFormulation form){
		if(form==null)return null;
		
		if(form instanceof PropositionVariable){
			return this.inference_propositionVariable((PropositionVariable) form);
		}
		if(form instanceof PredicateFormulation){
			return this.inference_predicateFormulation((PredicateFormulation) form);
		}
		if(form instanceof LogicExpression)
			return this.inference_expression((LogicExpression) form);
		if(form instanceof Universal)
			return this.inference_universal((Universal) form);
		if(form instanceof Existential)
			return this.inference_existential((Existential) form);
		
		return null;
	}
	
	Boolean inference_propositionVariable(PropositionVariable var){
		if(var==null)return null;
		if(var.getT_value()==null)return null;
		else return var.getT_value().getBool_val();
	}
	Boolean inference_predicateFormulation(PredicateFormulation var){
		if(var==null)return null;
		if(var.getAssociated_relations()==null)return null;
		
		List<LObject> values = new ArrayList<LObject>();
		List<Variable> vars = var.getVariables();
		for(Variable vi:vars)
			values.add(vi.getObject());
		
		return this.searcher.exist_relation(var.getAssociated_relations(), values);
	}
	
	Boolean inference_expression(LogicExpression expr){
		if(expr==null||expr.getOperator()==null)return null;
		return this.inference_operator(expr.getOperator());
	}
	Boolean inference_operator(LogicOperator op){
		if(op==null)return null;
		
		if(op instanceof Conjunction){
			List<LogicFormulation> forms = ((Conjunction) op).getFormulations();
			for(LogicFormulation form:forms)
				if(this.inference_formulation(form)==false)
					return false;
			return true;
		}
		if(op instanceof Disjunction){
			List<LogicFormulation> forms = ((Disjunction) op).getFormulations();
			for(LogicFormulation form:forms)
				if(this.inference_formulation(form)==true)
					return true;
			return false;
		}
		if(op instanceof Negation){
			Boolean r = this.inference_formulation(((Negation) op).getFormulation());
			if(r==null)return null;
			return !r;
		}
		if(op instanceof Implication){
			Boolean r1 = this.inference_formulation(((Implication) op).getPremise());
			Boolean r2 = this.inference_formulation(((Implication) op).getConclusion());
			if(r1==null||r2==null)return null;
			return (!r1)||r2;
		}
		if(op instanceof Equivalence){
			Boolean r1 = this.inference_formulation(((Equivalence) op).getFormulation1());
			Boolean r2 = this.inference_formulation(((Equivalence) op).getFormulation2());
			if(r1==null||r2==null)return null;
			return (r1&&(!r2))||((!r1)&&r2);
		}
		
		return null;
	}
	
	Boolean inference_universal(Universal u){
		if(u==null)return null;
		if(u.getDomain()==null||u.getScope_formulation()==null)return null;
		
		DiscourseDomain domain = u.getDomain();
		LogicFormulation form = u.getScope_formulation();
		
		LSet object_set = domain.getSet();
		List<LObject> objects = object_set.getValues();
		
		for(LObject value:objects){
			LogicAssigner.assignVariable(domain.getIter(), value);
			if(!this.inference_formulation(form))
				return false;
		}
		
		return true;
	}
	Boolean inference_existential(Existential e){
		if(e==null||e.getDomain()==null||e.getDomain().getSet()==null||e.getScope_formulation()==null)return null;
		
		List<LObject> objects = e.getDomain().getSet().getValues();
		
		for(LObject value:objects){
			LogicAssigner.assignVariable(e.getDomain().getIter(), value);
			if(this.inference_formulation(e.getScope_formulation()))
				return true;
		}
		
		return false;
	}
	
	
	/*
	 *	Inference Functions:
	 *		1. inference: LogicFormulation
	 *		2. Atom: PropositionVariable, PredicateFormulation
	 *		 
	 * 
	 */
	Boolean inferencePropositionVariable(PropositionVariable p){
		if(p==null||p.getT_value()==null)return null;
		return p.getT_value().getBool_val();
	}
	
	
	/*
	 *	Internal Class: LRelationSet Searcher
	 *	 
	 */
	static class LRelationSetSearcher{
		Map<LRelationSet,Map<String,LRelation>> map = new HashMap<LRelationSet,Map<String,LRelation>>();
		
		public void put(LRelationSet relations){
			if(relations==null)return;
			if(this.map.containsKey(relations)){
				return;
			}
			
			Map<String,LRelation> relation_map = this.map.get(relations);
			List<LRelation> rlist = relations.getRelations();
			
			for(LRelation r:rlist){
				relation_map.put(this.generateLRelationID(r.getElements()), r);
			}
			
			this.map.put(relations, relation_map);
		}
		public void remove(LRelationSet relations){this.map.remove(relations);}
		public Map<String,LRelation> get(LRelationSet relations){return this.map.get(relations);}
		public void update(LRelationSet relations){
			if(this.map.containsKey(relations))
				this.map.remove(relations);
			this.put(relations);
		}
		public void clear(){this.map.clear();}
		
		public boolean exist_relation(Map<String,LRelation> relation_map,List<LObject> values){
			if(relation_map!=null)
				return relation_map.containsKey(this.generateLRelationID(values));
			return false;
		}
		public boolean exist_relation(LRelationSet relations, List<LObject> values){
			if(!this.map.containsKey(relations))
				return this.get(relations).containsKey(this.generateLRelationID(values));
			return false;
		}
		
		String generateLRelationID(List<LObject> values){
			if(values==null)return null;
			
			StringBuilder res = new StringBuilder();
			for(int i=0;i<values.size();i++){
				res.append(values.get(i).getId());
				if(i!=values.size()-1)res.append(", ");
			}
			return res.toString();
		}
		
	}
	
}
