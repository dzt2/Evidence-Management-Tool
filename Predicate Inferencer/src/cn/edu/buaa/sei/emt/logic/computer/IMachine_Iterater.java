package cn.edu.buaa.sei.emt.logic.computer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.creator.LogicAccessor;
import cn.edu.buaa.sei.emt.logic.creator.LogicAssigner;
import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
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
import cn.edu.buaa.sei.emt.logic.predicate.core.Quantification;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class IMachine_Iterater implements InferenceMachine{
	
	LogicFormulation form;
	String name;
	ComputableAnalyzer analyzer = new ComputableAnalyzer("IMachine_Iterater");
	
	public IMachine_Iterater(String name){this.name=name;}

	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Type: Argument Errors ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	@Override
	public void setFormulation(LogicFormulation form) {this.form=form;}

	@Override
	public LogicFormulation getFormulation() {return this.form;}

	/*
	 *	Variable Assigner (not for large amount...) 
	 */
	@Override
	public Bindable getVariable(String name) {
		Object element = LogicAccessor.getElementByName(name, form);
		if(element==null){
			try {
				throw this.getArgException("name", "getVariable(name)", 
						"Undefined Elements in formulation: \""+name+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(!(element instanceof Bindable)){
			try {
				throw this.getArgException("name", "getVariable(name)",
						"\""+ name+"\" is not a bindable object");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return (Bindable) element;
	}
	@Override
	public void setVariable(String name, Value val) {
		Bindable var = this.getVariable(name);
		if(var==null){
			try {
				throw this.getArgException("name", "setVariable(name,val)", 
						"Getting Variable \""+name+"\" failed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(var instanceof PropositionVariable){
			if(!(val instanceof BooleanObject)){
				try {
					throw this.getArgException("name-value", "setVariable(name,val)", "Type match failed.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			LogicAssigner.assignPropositionVariable((PropositionVariable)var, (BooleanObject)val);
		}
		else if(var instanceof Variable){
			if(!(val instanceof LObject)){
				try {
					throw this.getArgException("name-value", "setVariable(name,val)", "Type match failed.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			LogicAssigner.assignVariable((Variable)var, (LObject)val);
		}
		else if(var instanceof DiscourseDomain){
			if(!(val instanceof LSet)){
				try {
					throw this.getArgException("name-value", "setVariable(name,val)", "Type match failed.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			LogicAssigner.assignDiscourseDomain((DiscourseDomain)var, (LSet)val);
		}
		else if(var instanceof PredicateFormulation){
			if(!(val instanceof LRelationSet)){
				try {
					throw this.getArgException("name-value", "setVariable(name,val)", "Type match failed.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			LogicAssigner.assignPredicateFormulation((PredicateFormulation)var,(LRelationSet)val);
		}
	}

	/*
	 *	Validation Verification... 
	 */
	@Override
	public Boolean computable() {
		// TODO Auto-generated method stub
		return this.analyzer.computable(form);
	}
	
	
	

	/*
	 *	Computation Function... 
	 */
	@Override
	public Boolean safeInference(){
		if(this.computable()){
			this.ready();
			return this.inference();
		}
		return null;
	}
	@Override
	public Boolean inference() {
		// TODO Auto-generated method stub
		this.ready();
		return this.computeFormulation(form);
	}
	
	Map<PredicateFormulation,Map<String,LRelation>> relation_searcher =
			new HashMap<PredicateFormulation,Map<String,LRelation>>();
	void ready(){
		Set<Bindable> external = this.analyzer.getExternal();
		for(Bindable var:external){
			if(var instanceof PredicateFormulation){
				LRelationSet rset = ((PredicateFormulation) var).getAssociated_relations();
				if(rset==null)continue;
				
				Map<String,LRelation> relations = new HashMap<String,LRelation>();
				this.relation_searcher.put((PredicateFormulation) var, relations);
				
				for(int i=0;i<rset.getRelations().size();i++){
					LRelation relation = rset.getRelations().get(i);
					String id = this.getRelationID(relation);
					relations.put(id, relation);
				}
			}
		}
	}
	String getRelationID(LRelation r){
		if(r==null)return null;
		StringBuilder id = new StringBuilder();
		
		id.append(r.getName()).append("(");
		for(int i=0;i<r.getElements().size();i++){
			if(r.getElements().get(i)!=null){
				id.append(r.getElements().get(i).getId());
				if(i<r.getElements().size()-1)id.append(",");
			}
		}
		id.append(")");
		
		return id.toString();
	}
	String getRelationID(String name,List<LObject> elements){
		if(name==null)return null;
		StringBuilder id = new StringBuilder();
		
		id.append(name).append("(");
		for(int i=0;i<elements.size();i++){
			if(elements.get(i)!=null){
				id.append(elements.get(i).getId());
				if(i<elements.size()-1)id.append(",");
			}
		}
		id.append(")");
		
		return id.toString();
	}
	
	
	Boolean computeFormulation(LogicFormulation form){
		if(form==null){
			try {
				throw this.getArgException("form", "computeFormulation(form)",
						"Null Formulation is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(form instanceof PropositionVariable){
			return this.computePropositionVariable((PropositionVariable) form);
		}
		else if(form instanceof PredicateFormulation){
			return this.computePredicateFormulation((PredicateFormulation) form);
		}
		else if(form instanceof LogicExpression){
			return this.computeLogicExpression((LogicExpression) form);
		}
		else if(form instanceof Universal){
			return this.computeUniversal((Universal) form);
		}
		else if(form instanceof Existential){
			return this.computeExistential((Existential) form);
		}
		
		return null;
	}
	Boolean computePropositionVariable(PropositionVariable var){
		/*
		 *	Null Proposition return Null Result. 
		 */
		if(var==null){
			try {
				throw this.getArgException("var", "computePropositionVariable(var)",
						"Null Formulation is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		/*
		 * Unassigned Proposition [var.getT_value()==null] returns Null Result. 
		 */
		if(var.getT_value()!=null)
			return var.getT_value().getBool_val();
		else{
			try {
				throw this.getArgException("var", "computePropositionVariable(var)",
						"Unassigned var \""+var.getName()+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
	}
	Boolean computePredicateFormulation(PredicateFormulation form){
		/*
		 *	Null Predicate return Null Result. 
		 */
		if(form==null){
			try {
				throw this.getArgException("form", "computePredicateFormulation(form)",
						"Null Formulation is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		/*
		 *	Getting the map of relations with their generated ID. 
		 */
		Map<String,LRelation> relations = this.relation_searcher.get(form);
		
		/*
		 * The LRelationSet has not been associated to the predicate (unassigned to its relations)
		 */
		if(relations==null){
			try {
				throw this.getArgException("form", "computePredicateFormulation(form)",
						"Unassigned Predicate: \""+form.getName()+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		/*
		 * Generate the list of values of its variables:
		 * 		if some variables are unassigned, the computation cannot continue.
		 */
		List<LObject> values = new ArrayList<LObject>();
		for(int i=0;i<form.getVariables().size();i++){
			if(form.getVariables().get(i)!=null){
				LObject val = form.getVariables().get(i).getObject();
				if(val==null){
					try {
						throw this.getArgException("form", "computePredicateFormulation(form)",
								"Unassigned Predicate Variable: \""+form.getName()
								+"."+form.getVariables().get(i).getName()+"\"");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.err.println(e.getMessage());
					}
					return null;
				}
				values.add(val);
			}
		}
		
		/*
		 *	Judge Code: verify whether there is the relation in relation set.
		 *		--> the relation must match ID as follow:
		 *			"form.getName() (var1.value.id, var2.value.id,...,varn.value.id)"
		 */
		String rid = this.getRelationID(form.getName(),values);
		LRelation r = relations.get(rid);
		return r!=null;
	}
	Boolean computeLogicExpression(LogicExpression expr){
		// Null Verification
		if(expr==null){
			try {
				throw this.getArgException("expr", "computeLogicExpression(expr)",
						"Null Formulation is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		LogicOperator op = expr.getOperator();
		return computeLogicOperator(op);
	}
	Boolean computeLogicOperator(LogicOperator op) {
		// Null Verification
		if(op==null){
			try {
				throw this.getArgException("op", "computeLogicOperator(op)",
						"Null Operator is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		// main code.
		if(op instanceof Conjunction){
			Boolean containNull = false;
			
			List<LogicFormulation> children = ((Conjunction) op).getFormulations();
			for(int i=0;i<children.size();i++){
				Boolean res = this.computeFormulation(children.get(i));
				if(res==false)return false;
				else if(res==null)containNull=true;
			}
			
			if(!containNull)return true;
			else return null;
		}
		else if(op instanceof Disjunction){
			Boolean containNull = false;
			
			List<LogicFormulation> children = ((Disjunction) op).getFormulations();
			for(int i=0;i<children.size();i++){
				Boolean res = this.computeFormulation(children.get(i));
				if(res==true)return true;
				else if(res==null)containNull=true;
			}
			
			if(!containNull)return false;
			else return null;
		}
		else if(op instanceof Negation){
			Boolean res = this.computeFormulation(((Negation) op).getFormulation());
			if(res==null)return null;
			else return !res;
		}
		else if(op instanceof Implication){
			Boolean res1 = this.computeFormulation(((Implication) op).getPremise());
			if(res1==false)return true;
			else if(res1==null)return null;
			
			return this.computeFormulation(((Implication) op).getConclusion());
		}
		else if(op instanceof Equivalence){
			Boolean res1 = this.computeFormulation(((Equivalence) op).getFormulation1());
			if(res1==null)return null;
			Boolean res2 = this.computeFormulation(((Equivalence) op).getFormulation2());
			if(res2==null)return null;
			return res1.equals(res2);
		}
		
		return null;
	}
	
	Boolean computeQuantification(Quantification u){
		if(u==null){
			try {
				throw this.getArgException("u", "computeQuantification(u)",
						"Null Universal is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		if(u.getDomain()==null){
			try {
				throw this.getArgException(u.getName()+".domain", "computeQuantification(u)",
						"Null DiscourseDomain is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		if(u.getDomain().getSet()==null){
			try {
				throw this.getArgException(u.getName()+".domain.set", "computeQuantification(u)",
						"Unassigned Discourse Domain is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		if(u.getScope_formulation()==null){
			try {
				throw this.getArgException(u.getName()+".scope", "computeQuantification(u)",
						"Null Scope Formulation is uncomputable");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		return true;
	}
	Boolean computeUniversal(Universal u){
		if(this.computeQuantification(u)!=true){
			try {
				throw this.getArgException("u", "computeUniversal(u)",
						"Errors in Quantification domain|scope");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		// main code.
		Boolean containNull = false;
		List<LObject> values = u.getDomain().getSet().getValues();
		for(LObject val:values){
			LogicAssigner.assignVariable(u.getDomain().getIter(), val);
			Boolean res = this.computeFormulation(u.getScope_formulation());
			if(res==false)return false;
			else if(res==null)containNull = true;
		}
		if(containNull)return null;
		else return true;
	}
	Boolean computeExistential(Existential u){
		if(this.computeQuantification(u)!=true){
			try {
				throw this.getArgException("u", "computeExistential(u)",
						"Errors in Quantification domain|scope");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return null;
		}
		
		// main code.
		Boolean containNull = false;
		List<LObject> values = u.getDomain().getSet().getValues();
		for(LObject val:values){
			LogicAssigner.assignVariable(u.getDomain().getIter(), val);
			Boolean res = this.computeFormulation(u.getScope_formulation());
			if(res==true)return true;
			else if(res==null)containNull = true;
		}
		if(containNull)return null;
		else return false;
	}
	
	
	
	
}
