package cn.edu.buaa.sei.emt.logic.predicate.compute;

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
import cn.edu.buaa.sei.lmf.ManagedObject;
import cn.edu.buaa.sei.lmf.Type;

public class LogicAccessor {
	LogicFormulation form;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<Object,Set<String>> name_map = new HashMap<Object,Set<String>>();
	
	public LogicAccessor(LogicFormulation form){
		this.form = form;
		this.update();
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Argument Errors Found!");
		code.append("\nType: Argument Errors: ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	void update(){
		if(this.form==null){
			try {
				throw this.getArgException("formulation", "update", "try to update name space for null formulation");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//...
		this.map.clear();
		this.name_map.clear();
		this.updateFormulation(this.form);
	}
	
	/*
	 *	Getter & Setter 
	 */
	public void setFormulation(LogicFormulation form){
		this.form = form;
		this.update();
	}
	public LogicFormulation getFormulation(){return this.form;}
	public Set<String> getNames(){return this.map.keySet();}
	public Object getElement(String name) throws Exception{
		if(this.map.containsKey(name))
			return this.map.get(name);
		else{
			throw this.getArgException(name, "getElement", 
					"try to access unexistential object: "+name);
		}
	}
	public Type getTypeOfElement(String name){
		if(this.map.containsKey(name)){
			Object obj = this.map.get(name);
			if(obj instanceof ManagedObject){
				return ((ManagedObject) obj).type();
			}
			else{
				try {
					throw this.getArgException("name", "getTypeOfElement", 
							"the extracted object <"+name+"> is not managedObject!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			try {
				throw this.getArgException(name, "getTypeOfElement", 
						"try to access unexistential object: "+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 *	Creating Names ...
	 *	I. LogicFormulation
	 *		1. PropositionVariable, PredicateFormulation
	 *		2. LogicExpression: Conjunction, Disjunction, Negation, Implication, Equivalence
	 *		3. Universal, Existential. 
	 *	II. Bindable
	 *		1. Variable, PropositionVariable
	 *		2. DiscourseDomain
	 *		3. PredicateFormulation
	 */
	void addNameForElement(String name,Object obj) throws Exception{
		if(name==null)return;
		if(this.map.containsKey(name)){
			if(this.map.get(name)!=obj){
				throw this.getArgException("name", "addNameForElement", "name conflicts");
			}
			return;
		}
		
		// pre-processe the names of object.
		Set<String> names = this.name_map.get(obj);
		if(names==null){
			names = new HashSet<String>();
			this.name_map.put(obj, names);
		}
		
		// puting the name
		this.map.put(name, obj);
		names.add(name);
		
	}
	
	void updateFormulation(LogicFormulation form){
		if(form==null){
			try {
				throw this.getArgException("form", "updateFormulation", 
						"try to update null logic formulation");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ... 
		if(form instanceof PropositionVariable)
			this.updatePropositionVariable((PropositionVariable) form);
		else if(form instanceof PredicateFormulation)
			this.updatePredicate((PredicateFormulation) form);
		else if(form instanceof LogicExpression)
			this.updateLogicExpression((LogicExpression) form);
		else if(form instanceof Quantification)
			this.updateQuantification((Quantification) form);
	}
	
	void updateVariable(Variable var){
		if(var==null){
			try {
				throw this.getArgException("var", "updateVariable", 
						"try to update the name space of null object");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			this.addNameForElement(var.getName(), var);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	void updateDiscrouseDomain(DiscourseDomain domain){
		if(domain==null)
			try {
				throw this.getArgException("domain", "updateDiscourseDomain", 
						"try to update null discourse domain.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// Add original domain name at first.
		try {
			this.addNameForElement(domain.getName(), domain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		// getting the name space.
		Set<String> names = this.name_map.get(domain);
		if(names==null){
			names = new HashSet<String>();
			this.name_map.put(domain, names);
		}
		
		// only add iterator names in it.
		for(String name:names){
			try {
				this.addNameForElement(name+".itor", domain.getIter());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
	}
	void updatePropositionVariable(PropositionVariable var){
		/*if(var==null){
			try {
				throw this.getArgException("var", "updatePropositionVariable", 
						"try to update the name space of null object");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String name = var.getName();
		if(this.map.containsKey(name)){
			try {
				throw this.getArgException("var", "updatePropositionVariable", 
						"potential name conflict["+name+"]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		else this.map.put(name, var);*/
		this.updateVariable(var);
	}
	void updatePredicate(PredicateFormulation p){
		if(p==null){
			try {
				throw this.getArgException("p", "updatePredicate", 
						"try to update the name space of null object");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// update the original name of predicate at first.
		try {
			this.addNameForElement(p.getName(), p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		// Update the original names of sub variables at first.
		List<Variable> vars = p.getVariables();
		for(Variable var:vars){
			this.updateVariable(var);
		}
		
		// Prepare the name list of predicate.
		Set<String> predicate_names = this.name_map.get(p);
		if(predicate_names==null){
			predicate_names = new HashSet<String>();
			this.name_map.put(p, predicate_names);
		}
		
		// adding utility name for variables.
		for(String name:predicate_names){
			for(int i=0;i<vars.size();i++){
				String namei = name+"."+vars.get(i).getName();
				String _argi = name+"._arg"+i;
				try {
					this.addNameForElement(namei, vars.get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				
				try {
					this.addNameForElement(_argi, vars.get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
		}
	}
	
	void updateLogicExpression(LogicExpression expr){
		if(expr==null)
			try {
				throw this.getArgException("expr", "updateLogicExpression", 
						"try to update null logic expression.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// updating original name
		try {
			this.addNameForElement(expr.getName(), expr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		// Getting the name space of logic expression.
		Set<String> names = this.name_map.get(expr);
		if(names==null){
			names = new HashSet<String>();
			this.name_map.put(expr, names);
		}
		// updating the argument names for sub formulations
		for(String name:names){
			this.updateLogicOperator(name, expr.getOperator());
		}
		// updating the iterator...
		this.updateOperatorFormulation(expr.getOperator());
	}	
	void updateLogicOperator(String name,LogicOperator op){
		if(name==null)return;
		if(op==null){
			try {
				throw this.getArgException("op", "updateLogicOperator", 
						"try to update null operator");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(op instanceof Conjunction){
			List<LogicFormulation> forms = ((Conjunction) op).getFormulations();
			for(int i=0;i<forms.size();i++){
				String namei = name+"."+forms.get(i).getName();
				String _argi = name+"._arg"+i;
				
				try {
					this.addNameForElement(namei, forms.get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				
				try {
					this.addNameForElement(_argi, forms.get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
		}
		else if(op instanceof Disjunction){
			List<LogicFormulation> forms = ((Disjunction) op).getFormulations();
			for(int i=0;i<forms.size();i++){
				String namei = name+"."+forms.get(i).getName();
				String _argi = name+"._arg"+i;
				
				try {
					this.addNameForElement(namei, forms.get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				
				try {
					this.addNameForElement(_argi, forms.get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
		}
		else if(op instanceof Negation){
			LogicFormulation form = ((Negation) op).getFormulation();
			String namei = name+"."+ form.getName();
			String _argi = name+"._arg";
			
			try {
				this.addNameForElement(namei, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			try {
				this.addNameForElement(_argi, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		else if(op instanceof Implication){
			LogicFormulation premise = ((Implication) op).getPremise();
			LogicFormulation conclusion = ((Implication) op).getConclusion();
			
			try {
				this.addNameForElement(name+".premise", premise);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			try {
				this.addNameForElement(name+"._arg0", premise);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			try {
				this.addNameForElement(name+".conclusion", conclusion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+"._arg1", conclusion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			try {
				this.addNameForElement(name+"."+premise.getName(), premise);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+"."+conclusion.getName(), conclusion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
		}
		else if(op instanceof Equivalence){
			LogicFormulation f1 = ((Equivalence) op).getFormulation1();
			LogicFormulation f2 = ((Equivalence) op).getFormulation2();
			
			try {
				this.addNameForElement(name+"."+f1.getName(), f1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+".formulation1", f1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+"._arg0", f1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			try {
				this.addNameForElement(name+"."+f2.getName(), f2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+".formulation2", f2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+"._arg1", f2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
	}
	void updateOperatorFormulation(LogicOperator op){
		if(op==null)return;
		
		if(op instanceof Conjunction){
			List<LogicFormulation> forms = ((Conjunction) op).getFormulations();
			for(LogicFormulation form:forms)
				this.updateFormulation(form);
		}
		else if(op instanceof Disjunction){
			List<LogicFormulation> forms = ((Disjunction) op).getFormulations();
			for(LogicFormulation form:forms)
				this.updateFormulation(form);
		}
		else if(op instanceof Negation){
			this.updateFormulation(((Negation) op).getFormulation());
		}
		else if(op instanceof Implication){
			this.updateFormulation(((Implication) op).getPremise());
			this.updateFormulation(((Implication) op).getConclusion());
		}
		else if(op instanceof Equivalence){
			this.updateFormulation(((Equivalence) op).getFormulation1());
			this.updateFormulation(((Equivalence) op).getFormulation2());
		}
	}
	
	void updateQuantification(Quantification q){
		if(q==null){
			try {
				throw this.getArgException("q", "updateQuantification", 
						"try to update null quantification");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// updating original names
		try {
			this.addNameForElement(q.getName(), q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		// preparing names
		Set<String> names = this.name_map.get(q);
		if(names==null){
			names = new HashSet<String>();
			this.name_map.put(q, names);
		}
		
		// updating reference names
		for(String name:names){
			try {
				this.addNameForElement(name+".domain", q.getDomain());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+".scope", q.getScope_formulation());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+"."+q.getDomain().getName(), q.getDomain());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			try {
				this.addNameForElement(name+"."+q.getScope_formulation().getName(), 
						q.getScope_formulation());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		
		// updating iterately
		this.updateDiscrouseDomain(q.getDomain());
		this.updateFormulation(q.getScope_formulation());
	}
	
	
	
}
