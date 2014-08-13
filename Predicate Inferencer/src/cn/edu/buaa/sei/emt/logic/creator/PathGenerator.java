package cn.edu.buaa.sei.emt.logic.creator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Disjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Equivalence;
import cn.edu.buaa.sei.emt.logic.predicate.core.Implication;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicOperator;
import cn.edu.buaa.sei.emt.logic.predicate.core.Negation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Quantification;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class PathGenerator {
	// 1 - 1
	String name;
	LogicFormulation context;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<Object,Set<String>> reMap = new HashMap<Object,Set<String>>();
	
	public PathGenerator(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("PathGenerator "+name+"report an erros:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	Boolean match(String id,Object obj){
		if(id==null||obj==null){
			try {
				throw this.getArgException("id|obj", "match(id,obj)", "Invalid Inputs.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(context==null){
			try {
				throw this.getArgException("context", "match(id,object)", 
						"context has not been configuerated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		return obj == LogicAccessor.getElementByName(id, context);
	}
	Boolean updateReMap(Object parent,Set<String> names,Object obj){
		// Null Argument is invalid
		if(parent==null||names==null||names.isEmpty()||obj==null){
			try {
				throw this.getArgException("parent|names|obj", "updateReMap(parent,names,obj)",
						"Null Argument cannot be processed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		// unpressed parent: NULL
		if(!this.reMap.containsKey(parent)){
			try {
				throw this.getArgException("parent", "updateReMap(parent,names,obj)", 
						"parent have not been processed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		// unprocessed parent: Empty
		Set<String> prefixs = this.reMap.get(parent);
		if(prefixs.isEmpty()){
			try {
				throw this.getArgException("parent", "updateReMap(parent,names,obj)", 
						"parent have not been processed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		// obj: IDS Initialization
		Set<String> obj_ids = this.reMap.get(obj);
		if(obj_ids==null){
			obj_ids = new HashSet<String>();
			this.reMap.put(obj, obj_ids);
		}
		
		// Update the reMap
		for(String prefix:prefixs)
			for(String name:names){
				String id = prefix + "." + name;
				if(this.map.containsKey(id)){
					try {
						throw this.getArgException("generated id", "updateReMap(parent,names,obj)", 
								"\""+id+"\" conflicts");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				
				this.map.put(id, obj);
				obj_ids.add(id);
			}
		
		return true;
	}
	Boolean updateReMap(Set<String> ids,Object obj){
		if(obj==null||ids==null){return false;}
		
		Set<String> names = this.reMap.get(obj);
		if(names==null){
			names = new HashSet<String>();
			this.reMap.put(obj, names);
		}
		
		for(String id:ids){
			if(this.map.containsKey(id))continue;
			this.map.put(id, obj);
			names.add(id);
		}
		return true;
	}
	
	/*
	 *	Getter & Setter 
	 */
	public String getName(){return this.name;}
	public void setName(String name){
		this.name = name;
	}
	public Object getObject(String id){
		if(this.map.containsKey(id))
			return this.map.get(id);
		try {
			throw this.getArgException("id", "getObject(id)", "ID \""+id+"\" not defined");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Set<String> getAllIDs(){return this.map.keySet();}
	public Set<String> getIDsOfObject(Object obj){
		if(this.reMap.containsKey(obj))
			return this.reMap.get(obj);
		try {
			throw this.getArgException("obj", "getIDofObject", "object is not in context.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public LogicFormulation getContext(){return this.context;}
	public void setContext(LogicFormulation context){
		this.context=context;
		if(!this.update()){
			try {
				throw this.getArgException("context", "setContext(context)", 
						"Updating Failed! The generated ID is invalid!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*Analyzer*/
	Boolean update(){
		if(this.context==null){
			try {
				throw this.getArgException("context", "update()", "context configuration failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		this.map.clear();
		this.reMap.clear();
		
		Set<String> names = new HashSet<String>();
		names.add(context.getName());
		
		if(!this.updateReMap(names, context)){
			try {
				throw this.getArgException("reMap", "update()","Initialization Failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return this.processFormulation(context);
	}
	
	Boolean processFormulation(LogicFormulation form){
		if(form==null){
			try {
				throw this.getArgException("form", 
						"processFormulation(form)", "Null argument cannot be processed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(form instanceof PropositionVariable){return this.processPropositionVariable((PropositionVariable) form);}
		else if(form instanceof PredicateFormulation){return this.processPredicate((PredicateFormulation) form);}
		else if(form instanceof LogicExpression){return this.processLogicExpression((LogicExpression) form);}
		else if(form instanceof Quantification){return this.processQuantification((Quantification) form);}
		
		return false;
	}
	
	Boolean processPropositionVariable(PropositionVariable var){
		return this.processVariable(var);
	}
	Boolean processVariable(Variable var){
		if(var==null){
			try {
				throw this.getArgException("var", "processVariable(var)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	Boolean processDiscourseDomain(DiscourseDomain domain){
		if(domain==null){
			try {
				throw this.getArgException("domain", "processDiscourseDomain(domain)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(domain.getIter()==null){
			try {
				throw this.getArgException("domain.iter", "processDiscourseDomain(domain)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> names = new HashSet<String>();
		
		// Iterator
		names.add(domain.getIter().getName());
		names.add(LogicAccessor.DOMAIN_ITOR);
		this.updateReMap(domain, names, domain.getIter());
		
		return true;
	}
	Boolean processPredicate(PredicateFormulation form){
		if(form==null){
			try {
				throw this.getArgException("form", "processPredicate(form)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		List<Variable> children = form.getVariables();
		Set<String> names = new HashSet<String>();
		for(int i=0;i<children.size();i++){
			if(children.get(i)==null){
				try {
					throw this.getArgException("form.variables["+i+"]", 
							"processPredicate(form)", i+" variable is null");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			names.clear();
			names.add(children.get(i).getName());
			names.add(LogicAccessor.ARG_PREFIX+i);
			this.updateReMap(form, names, children.get(i));
		}
		
		return true;
	}
	
	Boolean processLogicExpression(LogicExpression expr){
		if(expr==null){
			try {
				throw this.getArgException("expr", "processLogicExpression(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		LogicOperator op = expr.getOperator();
		if(op==null){
			try {
				throw this.getArgException("expr.op", "processLogicExpression(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(op instanceof Conjunction){return this.processConjunction(expr);}
		else if(op instanceof Disjunction){return this.processDisjunction(expr);}
		else if(op instanceof Negation){return this.processNegation(expr);}
		else if(op instanceof Implication){return this.processImplication(expr);}
		else if(op instanceof Equivalence){return this.processEquivalence(expr);}
		
		return false;
	}
	Boolean processConjunction(LogicExpression expr){
		if(expr==null||expr.getOperator()==null){
			try {
				throw this.getArgException("expr", 
						"processConjunction(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!(expr.getOperator() instanceof Conjunction)){
			try {
				throw this.getArgException("expr.op", 
						"processConjunction(expr)", "Type unmatch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Conjunction op = (Conjunction) expr.getOperator();
		List<LogicFormulation> forms = op.getFormulations();
		Set<String> names = new HashSet<String>();
		
		for(int i=0;i<forms.size();i++){
			if(forms.get(i)==null){
				try {
					throw this.getArgException("expr.op.variables["+i+"]", 
							"processConjunction(expr)", "null element");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			names.clear();
			names.add(forms.get(i).getName());
			names.add(LogicAccessor.ARG_PREFIX+i);
			this.updateReMap(expr, names, forms.get(i));
		}
		
		Boolean res = true;
		for(int i=0;i<forms.size();i++){
			Boolean mid_res = this.processFormulation(forms.get(i));
			if(!mid_res)res=false;
		}
		return res;
	}
	Boolean processDisjunction(LogicExpression expr){
		if(expr==null||expr.getOperator()==null){
			try {
				throw this.getArgException("expr", 
						"processDisjunction(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!(expr.getOperator() instanceof Disjunction)){
			try {
				throw this.getArgException("expr.op", 
						"processDisjunction(expr)", "Type unmatch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Disjunction op = (Disjunction) expr.getOperator();
		List<LogicFormulation> forms = op.getFormulations();
		Set<String> names = new HashSet<String>();
		
		for(int i=0;i<forms.size();i++){
			if(forms.get(i)==null){
				try {
					throw this.getArgException("expr.op.variables["+i+"]", 
							"processDisjunction(expr)", "null element");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			names.clear();
			names.add(forms.get(i).getName());
			names.add(LogicAccessor.ARG_PREFIX+i);
			this.updateReMap(expr, names, forms.get(i));
		}
		
		Boolean res = true;
		for(int i=0;i<forms.size();i++){
			Boolean mid_res = this.processFormulation(forms.get(i));
			if(!mid_res)res=false;
		}
		return res;
	}
	Boolean processNegation(LogicExpression expr){
		if(expr==null||expr.getOperator()==null){
			try {
				throw this.getArgException("expr", 
						"processNegation(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!(expr.getOperator() instanceof Negation)){
			try {
				throw this.getArgException("expr.op", 
						"processNegation(expr)", "Type unmatch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Negation op = (Negation) expr.getOperator();
		
		if(op.getFormulation()==null){
			try {
				throw this.getArgException("expr.op.child", 
						"processNegation(expr)", "Null child");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> names = new HashSet<String>();
		names.add(op.getFormulation().getName());
		names.add(LogicAccessor.NEG_CHILD);
		this.updateReMap(expr, names, op.getFormulation());
		
		return this.processFormulation(op.getFormulation());
	}
	Boolean processImplication(LogicExpression expr){
		if(expr==null||expr.getOperator()==null){
			try {
				throw this.getArgException("expr", 
						"processImplication(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!(expr.getOperator() instanceof Implication)){
			try {
				throw this.getArgException("expr.op", 
						"processImplication(expr)", "Type unmatch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Implication op = (Implication) expr.getOperator();
		if(op.getPremise()==null){
			try {
				throw this.getArgException("expr.op.premise", 
						"processImplication(expr)", "Null element");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(op.getConclusion()==null){
			try {
				throw this.getArgException("expr.op.conclusion", 
						"processImplication(expr)", "Null element");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> names = new HashSet<String>();
		
		LogicFormulation  premise = op.getPremise();
		names.add(LogicAccessor.IMPL_PREMISE);
		names.add(premise.getName());
		this.updateReMap(expr, names, premise);
		
		LogicFormulation conclusion = op.getConclusion();
		names.clear();
		names.add(LogicAccessor.IMPL_CONCLUSION);
		names.add(conclusion.getName());
		this.updateReMap(expr, names, conclusion);
		
		return this.processFormulation(premise)&&this.processFormulation(conclusion);
	}
	Boolean processEquivalence(LogicExpression expr){
		if(expr==null||expr.getOperator()==null){
			try {
				throw this.getArgException("expr", 
						"processEquivalence(expr)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!(expr.getOperator() instanceof Implication)){
			try {
				throw this.getArgException("expr.op", 
						"processEquivalence(expr)", "Type unmatch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Equivalence op = (Equivalence) expr.getOperator();
		if(op.getFormulation1()==null){
			try {
				throw this.getArgException("expr.op.form1", 
						"processEquivalence(expr)", "Null element");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(op.getFormulation2()==null){
			try {
				throw this.getArgException("expr.op.form2", 
						"processEquivalence(expr)", "Null element");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> names = new HashSet<String>();
		
		LogicFormulation f1 = op.getFormulation1();
		LogicFormulation f2 = op.getFormulation2();
		
		names.clear();
		names.add(LogicAccessor.EQ_F1);
		names.add(f1.getName());
		this.updateReMap(expr, names, f1);
		
		names.clear();
		names.add(LogicAccessor.EQ_F2);
		names.add(f2.getName());
		this.updateReMap(expr, names, f2);
		
		return this.processFormulation(f1)&&this.processFormulation(f2);
	}
	
	Boolean processQuantification(Quantification q){
		if(q==null){
			try {
				throw this.getArgException("q", "processQuantification(q)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(q.getDomain()==null){
			try {
				throw this.getArgException("q.domain", "processQuantification(q)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(q.getScope_formulation()==null){
			try {
				throw this.getArgException("q.scope", "processQuantification(q)", "Null argument is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> names = new HashSet<String>();
		
		// domain
		DiscourseDomain domain = q.getDomain();
		names.clear();
		names.add(LogicAccessor.Q_DOMAIN);
		names.add(domain.getName());
		this.updateReMap(q, names, domain);
		
		// scope
		LogicFormulation scope = q.getScope_formulation();
		names.clear();
		names.add(LogicAccessor.Q_SCOPE);
		names.add(scope.getName());
		this.updateReMap(q, names, scope);
		
		return this.processDiscourseDomain(domain)&&this.processFormulation(scope);
	}
	
	
	
	
	
}
