package cn.edu.buaa.sei.emt.logic.computer;

import java.util.List;

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

public class LogicPrinter {
	
	public String printFormulation(LogicFormulation formulation){
		if(formulation ==null)return null;
		
		if(formulation instanceof PropositionVariable)
			return this.printPropositionVariable((PropositionVariable) formulation);
		if(formulation instanceof PredicateFormulation)
			return this.printPredicateFormulation((PredicateFormulation) formulation);
		if(formulation instanceof LogicExpression)
			return this.printLogicExpression((LogicExpression) formulation);
		if(formulation instanceof Universal)
			return this.printUniversal((Universal) formulation);
		if(formulation instanceof Existential)
			return this.printExistential((Existential) formulation);
		
		return null;
	}
	
	public String printPropositionVariable(PropositionVariable var){
		if(var==null)return null;
		return var.getName();
	}
	public String printPredicateFormulation(PredicateFormulation predicate){
		if(predicate==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append(predicate.getName()).append("(");
		
		List<Variable>  variables=predicate.getVariables();
		for(int i=0;i<variables.size();i++){
			Variable var = variables.get(i);
			code.append(var.getName());
			if(i!=variables.size()-1)code.append(", ");
		}
		
		code.append(")");
		return code.toString();
	}
	
	
	public String printLogicExpression(LogicExpression expr){
		if(expr==null||expr.getOperator()==null)return null;
		else return "("+this.printLogicOperator(expr.getOperator())+")";
	}
	public String printLogicOperator(LogicOperator op){
		if(op==null)return null;
		StringBuilder code = new StringBuilder();
		
		if(op instanceof Conjunction){
			List<LogicFormulation> formulations = ((Conjunction)op).getFormulations();
			for(int i=0;i<formulations.size();i++){
				code.append(this.printFormulation(formulations.get(i)));
				if(i!=formulations.size()-1)code.append(" && ");
			}
		}
		else if(op instanceof Disjunction){
			List<LogicFormulation> formulations = ((Disjunction)op).getFormulations();
			for(int i=0;i<formulations.size();i++){
				code.append(this.printFormulation(formulations.get(i)));
				if(i!=formulations.size()-1)code.append(" || ");
			}
		}
		else if(op instanceof Negation){
			LogicFormulation formulation = ((Negation)op).getFormulation();
			code.append("! ").append(this.printFormulation(formulation));
		}
		else if(op instanceof Implication){
			LogicFormulation premise = ((Implication)op).getPremise();
			LogicFormulation conclusion = ((Implication)op).getConclusion();
			code.append(this.printFormulation(premise)).append(" --> ").append(this.printFormulation(conclusion));
		}
		else if(op instanceof Equivalence){
			LogicFormulation f1 = ((Equivalence)op).getFormulation1();
			LogicFormulation f2 = ((Equivalence)op).getFormulation2();
			code.append(this.printFormulation(f1)).append(" <--> ").append(this.printFormulation(f2));
		}
		
		return code.toString();
	}
	
	public String printUniversal(Universal u){
		if(u==null||u.getDomain()==null||u.getScope_formulation()==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("for each "+u.getDomain().getIter().getName()+" in ").append(u.getDomain().getName()).append(" [");
		code.append(this.printFormulation(u.getScope_formulation())).append("]");
		
		return code.toString();
	}
	public String printExistential(Existential e){
		if(e==null||e.getDomain()==null||e.getScope_formulation()==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("for some "+e.getDomain().getIter().getName()+" in ").append(e.getDomain().getName()).append(" [");
		code.append(this.printFormulation(e.getScope_formulation())).append("]");
		
		return code.toString();
	}
	
	
}
