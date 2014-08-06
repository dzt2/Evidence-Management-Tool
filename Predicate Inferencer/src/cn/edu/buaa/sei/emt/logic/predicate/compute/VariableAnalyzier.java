package cn.edu.buaa.sei.emt.logic.predicate.compute;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Disjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Equivalence;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.Implication;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicOperator;
import cn.edu.buaa.sei.emt.logic.predicate.core.Negation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class VariableAnalyzier {
	LogicFormulation formulation;
	Set<Bindable> extern_vars = new HashSet<Bindable>();
	Set<Bindable> internal_vars = new HashSet<Bindable>();
	
	public VariableAnalyzier(){}
	public VariableAnalyzier(LogicFormulation formulation){
		this.setFormulation(formulation);
	}
	
	/*
	 *	Getter: Formulation, External Variable, Internal Variable
	 *	Setter: Formulation
	 */
	public LogicFormulation getLogicFormulation(){return this.formulation;}
	public Set<Bindable> getExternalVariables(){return this.extern_vars;}
	public Set<Bindable> getInternalVariables(){return this.internal_vars;}
	public void setFormulation(LogicFormulation form){
		if(form==null)return;
		this.formulation=form;
		this.extern_vars.clear();
		this.internal_vars.clear();
		
		this.analyze_formulation(formulation);
	}
	
	/*
	 *	Analyzer Functions:
	 *		1. LogicExpression: Conjunction, Disjunction, Negation, Implication, Equivalence
	 *		2. Atom Formulation: PropositionVariable, PredicateFormulation
	 *		3. Quantification: Universal, Existential 
	 */
	void analyze_formulation(LogicFormulation form){
		if(form==null)return;
		
		if(form instanceof PropositionVariable){
			this.insert_external((PropositionVariable)form);
			this.analyze_propositionVariable((PropositionVariable) form);
		}
		else if(form instanceof PredicateFormulation){
			this.insert_external((PredicateFormulation)form);
			this.analyze_predicate_formulation((PredicateFormulation) form);
		}
		else if(form instanceof LogicExpression){
			this.analyze_logic_expression((LogicExpression) form);
		}
		else if(form instanceof Universal)
			this.analyze_universal((Universal) form);
		else if(form instanceof Existential)
			this.analyze_existential((Existential) form);

	}
	void analyze_propositionVariable(PropositionVariable p){
		if(p==null)return;
		return;
	}
	void analyze_predicate_formulation(PredicateFormulation p){
		if(p==null)return;
		List<Variable> vars = p.getVariables();
		for(Variable var:vars)
			this.insert_external(var);
	}
	
	void analyze_logic_expression(LogicExpression expr){
		if(expr==null)return;
		LogicOperator op = expr.getOperator();
		
		this.analyze_logic_operator(op);
	}
	void analyze_logic_operator(LogicOperator op){
		if(op==null)return;
		
		if(op instanceof Conjunction){
			List<LogicFormulation> forms = ((Conjunction) op).getFormulations();
			for(LogicFormulation form:forms)
				this.analyze_formulation(form);
		}
		else if(op instanceof Disjunction){
			List<LogicFormulation> forms = ((Disjunction) op).getFormulations();
			for(LogicFormulation form:forms)
				this.analyze_formulation(form);
		}
		else if(op instanceof Negation){
			LogicFormulation form = ((Negation) op).getFormulation();
			this.analyze_formulation(form);
		}
		else if(op instanceof Implication){
			LogicFormulation premise = ((Implication) op).getPremise();
			LogicFormulation conclusion = ((Implication) op).getConclusion();
			this.analyze_formulation(premise);
			this.analyze_formulation(conclusion);
		}
		else if(op instanceof Equivalence){
			this.analyze_formulation(((Equivalence) op).getFormulation1());
			this.analyze_formulation(((Equivalence) op).getFormulation2());
		}
	}
	
	void analyze_universal(Universal u){
		if(u==null)return;
		
		this.internal_vars.add(u.getDomain().getIter());
		this.insert_external(u.getDomain());
		
		this.analyze_formulation(u.getScope_formulation());
	}
	void analyze_existential(Existential e){
		if(e==null)return;
		
		this.internal_vars.add(e.getDomain().getIter());
		this.insert_external(e.getDomain());
		
		this.analyze_formulation(e.getScope_formulation());
	}
	
	void insert_external(Bindable var){
		//System.out.println("Try to Insert");
		if(!this.internal_vars.contains(var))
			this.extern_vars.add(var);
	}
}
