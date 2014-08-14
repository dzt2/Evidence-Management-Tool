package cn.edu.buaa.sei.emt.logic.creator;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
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
import cn.edu.buaa.sei.emt.logic.predicate.core.Quantification;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class LogicXMLGenerator {
	String name;
	Document doc;
	Map<Object,String> data;
	Set<Object> verified = new HashSet<Object>();
	
	public LogicXMLGenerator(String name,Document doc){this.name=name;this.doc=doc;}
	
	/*
	 *	Getter & Setter 
	 */
	public String getName(){return this.name;}
	public void setName(String name){this.name=name;}
	public void setDocument(Document doc){this.doc=doc;}
	public Document getDocument(){return this.doc;}
	public void setData(Map<Object,String> data){this.data=data;}
	public Map<Object,String> getData(){return this.data;}
	
	/*
	 *	Element Tags
	 *	<LogicFormulation> /select child
	 *		<PropositionVar>
	 *		<Predicate>
	 *			<VariableRef> *
	 *		<LogicExpression>
	 *			<Conjunction>
	 *				<FormulationList> 1
	 * 			<Disjunction>
	 * 				<FormulationList> 1
	 * 			<Negation>
	 * 				<Child> 1
	 * 			<Implication>
	 * 				<premise> 1
	 * 				<conclusion> 1
	 * 			<Equivalence>
	 * 				<f1> 1
	 * 				<f2> 1
	 * 		<Universal>|<Existential>
	 * 			<DiscourseDomain> 1
	 * 				<VariableRef> 1
	 * 			<Scope> 1
	 * 				<**formulation**>
	 * 	
	 * <VariableList>
	 * 		<Variable>
	 * 		<PropositionVar>
	 * 		<DiscourseDomain>
	 * 			<VariableRef>
	 */
	
	public static final String LOGIC_FORMULATION = "LogicFormulation";
	
	public static final String PROPOSITION_VAR = "PropositionVar";
	
	public static final String PREDICATE = "Predicate";
		public static final String VAR_REF = "VariableRef";
	
	public static final String LOGIC_EXPR = "LogicExpression";
		public static final String CONJUNCTION = "Conjunction";
			public static final String FORMULATION_LIST = "FormulationList"; 
		public static final String DISJUNCTION = "Disjunction";
		public static final String NEGATION = "Negation";
			public static final String CHILD = "Child";
		public static final String IMPLICATION = "Implication";
			public static final String PREMISE = "Premise";
			public static final String CONCLUSION = "Conclusion";
		public static final String EQUIVALENCE = "Equivalence";
			public static final String F1 = "f1";
			public static final String F2 = "f2";
	
	public static final String UNIVERSAL = "Universal";
	public static final String EXISTENTIAL = "Existential";
		public static final String DISCOURSE_DOMAIN = "DiscourseDomain";
		public static final String SCOPE = "Scope";
		
	public static final String VAR_LIST = "VariableList";
		public static final String VARIABLE = "Variable";
	
	
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
	
	/*
	 *	Validation Functions 
	 */
	Boolean validate(){
		// Null Verification
		if(this.doc==null){
			try {
				throw this.getArgException("doc", "validate()", 
						"Null Document cannot generate XML Elements for xml file");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(this.data==null){
			try {
				throw this.getArgException("data", "validate()", 
						"Null Data cannot generate XML Elements for xml file");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		this.verified.clear();
		
		// Self-Reference Check
		for(Object obj:this.data.keySet()){
			if(this.verified.contains(obj))continue;
			if(obj==null){
				try {
					throw this.getArgException("data", "validate()", "null elements in data");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			if(obj instanceof LogicFormulation){
				if(!this.validateFormulation((LogicFormulation) obj))return false;
			}
			else if(obj instanceof Variable){
				if(!this.validateVariable((Variable) obj))
					return false;
			}
			else if(obj instanceof DiscourseDomain){
				if(!this.validateDiscourseDomain((DiscourseDomain) obj))
					return false;
			}
		}
		return true;
	}
	
	Boolean validateFormulation(LogicFormulation form){
		if(this.validateObject(form)){
			if(form instanceof PropositionVariable){return this.validatePropositionVariable((PropositionVariable) form);}
			else if(form instanceof PredicateFormulation){return this.validatePredicate((PredicateFormulation) form);}
			else if(form instanceof LogicExpression){return this.validateLogicExpression((LogicExpression) form);}
			else if(form instanceof Quantification){return this.validateQuantification((Quantification) form);}
		}
		return false;
	}
	
	Boolean validateObject(Object obj){
		this.verified.add(obj);
		if(obj==null){
			try {
				throw this.getArgException("var", "validateObject(obj)", 
						"Null obj cannot generate XML Elements.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!this.data.containsKey(obj)){
			try {
				throw this.getArgException("obj", "validateObject(obj)", 
						"Null ID of obj cannot generate XML Elements.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	Boolean validatePropositionVariable(PropositionVariable var){
		return this.validateObject(var);
	}
	Boolean validateVariable(Variable var){
		return this.validateObject(var);
	}
	Boolean validateDiscourseDomain(DiscourseDomain domain){
		if(this.validateObject(domain)){
			if(this.validateVariable(domain.getIter()))return true;
			else{
				try {
					throw this.getArgException("domain.iter", 
							"validateDiscourseDomain(domain)", "Validation failed at "+domain.getName()+".iter");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		}
		else{
			try {
				throw this.getArgException("domain", 
						"validateDiscourseDomain(domain)", "Validation failed at "+domain);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}
	Boolean validatePredicate(PredicateFormulation form){
		if(this.validateObject(form)){
			List<Variable> vars = form.getVariables();
			for(int i=0;i<vars.size();i++){
				Variable var = vars.get(i);
				if(!this.validateVariable(var)){
					try {
						throw this.getArgException("form.variables["+i+"]", 
								"validatePredicate(form)", "Validation failed at "+form.getName()+"["+i+"]");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
			}
			return true;
		}
		else{
			try {
				throw this.getArgException("form", "validatePredicate(form)", 
						"Validation failed at predicate: "+form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}
	
	Boolean validateLogicExpression(LogicExpression expr){
		if(this.validateObject(expr)){
			if(this.validateOperator(expr.getOperator()))
				return true;
			try {
				throw this.getArgException("expr.op", "validateLogicExpression(expr)", 
						"Validation failed at "+expr.getOperator());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				throw this.getArgException("expr", "validateLogicExpression(expr)", 
						"Validation failed at "+expr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	Boolean validateOperator(LogicOperator op){
		if(op==null)return false;
		
		if(op instanceof Conjunction){
			List<LogicFormulation> forms = ((Conjunction) op).getFormulations();
			for(int i=0;i<forms.size();i++){
				if(!this.validateFormulation(forms.get(i))){
					try {
						throw this.getArgException("op.variables["+i+"]", "validateOperator(op)", 
								"validation failed at "+op.type().getSimpleName()+"["+i+"]");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
			}
			return true;
		}
		else if(op instanceof Disjunction){
			List<LogicFormulation> forms = ((Disjunction) op).getFormulations();
			for(int i=0;i<forms.size();i++){
				if(!this.validateFormulation(forms.get(i))){
					try {
						throw this.getArgException("op.variables["+i+"]", "validateOperator(op)", 
								"validation failed at "+op.type().getSimpleName()+"["+i+"]");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
			}
			return true;
		}
		else if(op instanceof Negation){
			if(!this.validateFormulation(((Negation) op).getFormulation())){
				try {
					throw this.getArgException("op.child", 
							"validateOperator(op)", "validation failed at Negation.child");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			return true;
		}
		else if(op instanceof Implication){
			if(!this.validateFormulation(((Implication) op).getPremise())){
				try {
					throw this.getArgException("op.premise", 
							"validateOperator(op)", "validation failed at Implication.premise");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			if(!this.validateFormulation(((Implication) op).getConclusion())){
				try {
					throw this.getArgException("op.conclusion", 
							"validateOperator(op)", "validation failed at Implication.conclusion");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			return true;
		}
		else if(op instanceof Equivalence){
			if(!this.validateFormulation(((Equivalence) op).getFormulation1())){
				try {
					throw this.getArgException("op.f1", 
							"validateOperator(op)", "validation failed at Equivalence.f1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			if(!this.validateFormulation(((Equivalence) op).getFormulation2())){
				try {
					throw this.getArgException("op.f2", 
							"validateOperator(op)", "validation failed at Equivalence.f2");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			return true;
		}
		
		return false;
	}
	
	Boolean validateQuantification(Quantification q){
		if(!this.validateObject(q)){
			try {
				throw this.getArgException("q", "validateQuantification(q)", 
						"Validation failed at "+q);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(!this.validateDiscourseDomain(q.getDomain())){
			try {
				throw this.getArgException("q.domain", "validateQuantification(q)", 
						"Validation failed at "+q.getDomain());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(!this.validateFormulation(q.getScope_formulation())){
			try {
				throw this.getArgException("q.scope", "validateQuantification(q)", 
						"Validation failed at "+q.getScope_formulation());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
	/*
	 *	Element Generator:
	 *		1. Formulation: propositionvariable,predicateformulation,logicexpression,quantification.
	 *		2. Bindable: variable,discourse domain, 
	 */
	public Element generateFormulation(LogicFormulation form){
		if(form==null){
			try {
				throw this.getArgException("form", "generateFormulation(form)",
						"null formulation cannot generate XML Element.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(form instanceof PropositionVariable){}
		else if(form instanceof PredicateFormulation){}
		else if(form instanceof LogicExpression){}
		else if(form instanceof Universal){}
		else if(form instanceof Existential){}
		
		return null;
	}
	
	Element generateProposition(String id,PropositionVariable var){
		if(var==null){
			try {
				throw this.getArgException("var", "generateFProposition(var)",
						"null Proposition Variable cannot generate XML Element.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Element elm = this.doc.createElement(PROPOSITION_VAR);
		elm.setAttribute("id", id);
		elm.setAttribute("name", var.getName());
		
		return elm;
	}
	Element generateVariable(String id,Variable var){
		if(var==null){
			try {
				throw this.getArgException("var", "generateVariable(var)",
						"null Variable cannot generate XML Element.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Element elm = doc.createElement(VARIABLE);
		elm.setAttribute("id", id);
		elm.setAttribute("name", var.getName());
		
		return elm;
	}
	Element generateDiscourseDomain(String id,DiscourseDomain domain){
		if(domain==null){
			try {
				throw this.getArgException("domain", "generateDiscourseDomain(domain)",
						"null Discourse Domain cannot generate XML Element.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Element elm = doc.createElement(DISCOURSE_DOMAIN);
		elm.setAttribute("id", id);
		elm.setAttribute("name", domain.getName());
		
		if(domain.getIter()!=null){
			Element iter = doc.createElement(VAR_REF);
			iter.setAttribute("id", domain.getIter().getName());
			elm.appendChild(iter);
		}
		
		return elm;
	}

	Element generatePredicate(String id,PredicateFormulation form){
		if(form==null){
			try {
				throw this.getArgException("form", "generatePredicate(form)",
						"null Predicate Formulation cannot generate XML Element.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Element elm = doc.createElement(PREDICATE);
		elm.setAttribute("id", form.getName());
		elm.setAttribute("name", form.getName());
		
		Element varlist = doc.createElement(VAR_LIST);
		List<Variable> vars = form.getVariables();
		for(int i=0;i<vars.size();i++){
			if(vars.get(i)==null){
				try {
					throw this.getArgException("variable list", "generatePredicate(form)",
							"null variable cannot be generated.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			Element ei = doc.createElement(VAR_REF);
			ei.setAttribute("id", vars.get(i).getName());
			varlist.appendChild(ei);
		}
		
		elm.appendChild(varlist);
		return elm;
	}
}
