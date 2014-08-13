package cn.edu.buaa.sei.emt.logic.computer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
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


public class ComputableAnalyzer {
	
	String name;
	/*
	 *	external: external variables, requires external information to be assigned.
	 *	internal: internal variables, no need to use external information for assignment.
	 *	
	 *	analyzed: the LogicFormulation to be analyzed in the analyzer.
	 *	struct_valid: whether the structure of formulation is valid.
	 *	
	 *	executing: the formulations being executed for analysis.
	 *	finished: the formulations have been analyzed and passed.
	 *	error_end: the formulations have been analyzed and failed.
	 * 
	 */
	Set<Bindable> external = new HashSet<Bindable>();
	Set<Bindable> internal = new HashSet<Bindable>();
	
	LogicFormulation analyzed;
	Boolean struct_valid = false;
	
	Set<Object> executing = new HashSet<Object>();
	Set<Object> finished = new HashSet<Object>();
	Set<Object> error_end = new HashSet<Object>();
	
	/*
	 *	Getter & Setter 
	 */
	public ComputableAnalyzer(String name){this.name=name;}
	public String getName(){return this.name;}
	public void setName(String name){this.name=name;}
	
	public LogicFormulation getAnalyzed(){return this.analyzed;}
	public void setAnalyzed(LogicFormulation analyzed){
		this.analyzed=analyzed;
		this.struct_valid = this.analysis();
	}
	
	
	public Boolean isStructureValid(){return this.struct_valid;}
	public Set<Bindable> getExternal(){return this.external;}
	public Set<Bindable> getInternal(){return this.internal;}
	
	public Set<Object> getExecutings(){return this.executing;}
	public Set<Object> getFinished(){return this.finished;}
	public Set<Object> getErrorEnds(){return this.error_end;}
	
	public Boolean computable(){
		if(!this.struct_valid){
			try {
				throw this.getArgException("Structure Invalid", "computable()",
						"Invalid Structure cannot be computed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		for(Bindable var:this.external){
			if(var==null||var.getValue()==null){
				try {
					throw this.getArgException("Unassigned External Bindable", "computable()",
							"Unassigined External Bindable cannot be computed.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				return false;
			}
		}
		return true;
	}
	public Boolean computable(LogicFormulation form){
		this.setAnalyzed(form);
		return this.computable();
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("ComputableAnalyzer "+name+" reports faults as follow:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	void putExternal(Bindable var){
		if(var==null)return;
		if(!this.internal.contains(var))
			this.external.add(var);
	}
	
	/*
	 *	Analysis Functions 
	 */
	Boolean analysis(){
		if(this.analyzed==null){
			try {
				throw this.getArgException("analyzed", "analysis()", 
						"Null analyzed formulation cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		this.external.clear();
		this.internal.clear();
		this.executing.clear();
		this.finished.clear();
		this.error_end.clear();
		
		Boolean res = this.analysisFormulation(analyzed);
		if(!res){
			try {
				throw this.getArgException("analyzed", "analysis()", 
						"The structure of analyzed formulation is invalid!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		return res;
	}
	
	Boolean analysisFormulation(LogicFormulation form){
		/*
		 *	Null Verification 
		 */
		if(!this.null_analysis(form)){
			try {
				throw this.getArgException("form", "analysisFormulation(form)", 
						"Null formulation cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		/*
		 *	Verify whether a circle is in the logic formulation... 
		 */
		if(!this.circle_analysis(form)){
			try {
				throw this.getArgException("circle", "analysisFormulation(form)", 
						"There is circle in the structure of formulation: "+form.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		// start the analysis
		//this.start(form);
		
		/*
		 *	main code
		 */
		Boolean res = false;
		if(form instanceof PropositionVariable){
			res = this.analysisPropositionVariable((PropositionVariable) form);
		}
		else if(form instanceof PredicateFormulation){
			res = this.analysisPredicateFormulation((PredicateFormulation) form);
		}
		else if(form instanceof LogicExpression){
			res = this.analysisLogicExpression((LogicExpression) form);
		}
		else if(form instanceof Quantification){
			res = this.analysisQuantification((Quantification) form);
		}
		
		// release the code.
		this.end(form, res);
		return res;
	}
	
	Boolean analysisPropositionVariable(PropositionVariable var){
		/*
		 *	Null Analysis 
		 */
		if(!this.null_analysis(var)){
			try {
				throw this.getArgException("form", "analysisPropositionVariable(form)", 
						"Null formulation cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		/*
		 *	Verify whether a circle is in the logic formulation... 
		 */
		if(!this.circle_analysis(var)){
			try {
				throw this.getArgException("circle", "analysisPropositionVariable(var)", 
						"There is circle in the structure of formulation: "+var.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		// start to analysis
		this.start(var);
		// main code
		this.putExternal(var);
		// finish the analysis
		this.end(var, true);
		return true;
	}
	Boolean analysisPredicateFormulation(PredicateFormulation form){
		/*
		 *	Null Verification 
		 */
		if(!this.null_analysis(form)){
			try {
				throw this.getArgException("form", "analysisPredicateFormulation(form)", 
						"Null formulation cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		/*
		 *	Verify whether a circle is in the logic formulation... 
		 */
		if(!this.circle_analysis(form)){
			try {
				throw this.getArgException("circle", "analysisPredicateFormulation(form)", 
						"There is circle in the structure of formulation: "+form.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		// start to analyze
		this.start(form);
		
		// main code
		this.putExternal(form);
		
		List<Variable> variables = form.getVariables();
		for(int i=0;i<variables.size();i++){
			this.putExternal(variables.get(i));
		}
		
		// end to analysis
		this.end(form, true);
		
		return true;
	}
	Boolean analysisLogicExpression(LogicExpression expr){
		/*
		 *	Null Verification 
		 */
		if(!this.null_analysis(expr)){
			try {
				throw this.getArgException("expr", "analysisLogicExpression(expr))", 
						"Null formulation cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			return false;
		}
		
		/*
		 *	Verify whether a circle is in the logic formulation... 
		 */
		if(!this.circle_analysis(expr)){
			try {
				throw this.getArgException("circle", "analysisLogicExpression(expr)", 
						"There is circle in the structure of formulation: "+expr.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			// end the analysis and put the formulation into fault way.
			
			return false;
		}
		
		// start to analyze
		this.start(expr);
		// main code
		LogicOperator op = expr.getOperator();
		Boolean res = this.analysisLogicOperator(op);
		// end to analyze
		this.end(expr, res);
		
		return res;
	}
	Boolean analysisLogicOperator(LogicOperator op){
		/*
		 *	Null Verification 
		 */
		if(!this.null_analysis(op)){
			try {
				throw this.getArgException("op", "analysisLogicOperator(op)", 
						"Null operator cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		/*
		 *	Verify whether a circle is in the logic formulation... 
		 */
		if(!this.circle_analysis(op)){
			try {
				throw this.getArgException("circle", "analysisLogicOperator(op)", 
						"There is circle in the structure of formulation: "+op.type().getSimpleName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		
		//start to analyze
		this.start(op);
		
		// main code.
		Boolean res = true;
		if(op instanceof Conjunction){
			List<LogicFormulation> children = ((Conjunction) op).getFormulations();
			for(int i=0;i<children.size();i++){
				if(!this.analysisFormulation(children.get(i)))
					res = false;
			}
		}
		else if(op instanceof Disjunction){
			List<LogicFormulation> children = ((Disjunction) op).getFormulations();
			for(int i=0;i<children.size();i++){
				if(!this.analysisFormulation(children.get(i)))
					res = false;
			}
		}
		else if(op instanceof Negation){
			LogicFormulation child = ((Negation) op).getFormulation();
			res = this.analysisFormulation(child);
		}
		else if(op instanceof Implication){
			LogicFormulation premise = ((Implication) op).getPremise();
			LogicFormulation conclusion = ((Implication) op).getConclusion();
			res = this.analysisFormulation(premise)&&this.analysisFormulation(conclusion);
		}
		else if(op instanceof Equivalence){
			LogicFormulation f1 = ((Equivalence) op).getFormulation1();
			LogicFormulation f2 = ((Equivalence) op).getFormulation2();
			res = this.analysisFormulation(f1)&&this.analysisFormulation(f2);
		}
		else res = false;
		
		// end to analyze
		this.end(op, res);
		
		return res;
	}
	Boolean analysisQuantification(Quantification q){
		/*
		 *	Null Verification 
		 */
		if(!this.null_analysis(q)){
			try {
				throw this.getArgException("op", "analysisLogicOperator(op)", 
						"Null operator cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		/*
		 *	Verify whether a circle is in the logic formulation... 
		 */
		if(!this.circle_analysis(q)){
			try {
				throw this.getArgException("circle", "analysisQuantification(q)", 
						"There is circle in the structure of formulation: "+q.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			return false;
		}
		
		// start to analyze
		this.start(q);
		
		// main code
		if(q.getDomain()!=null){
			if(q.getDomain().getIter()!=null)
				this.internal.add(q.getDomain().getIter());
			this.putExternal(q.getDomain());
		}
		Boolean res = this.analysisFormulation(q.getScope_formulation());
		
		// end to analyze
		this.end(q, res);
		
		return res;
	}
	
	Boolean null_analysis(Object obj){
		if(obj==null){
			try {
				throw this.getArgException("op", "analysisLogicOperator(op)", 
						"Null operator cannot be analyzed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			this.error_end.add(obj);
			return false;
		}
		return true;
	}
	Boolean circle_analysis(ManagedObject obj){
		if(this.executing.contains(obj)){
			try {
				throw this.getArgException("circle", "circle_analysis(obj)", 
						"There is circle in the structure of formulation: "+obj.type().getSimpleName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			// end the analysis and put the formulation into fault way.
			this.error_end.add(obj);
			return false;
		}
		return true;
	}
	void start(Object obj){
		if(obj!=null)this.executing.add(obj);
	}
	void end(Object obj,Boolean res){
		this.executing.remove(obj);
		if(res)this.finished.remove(obj);
		else this.error_end.add(obj);
	}
	
}
