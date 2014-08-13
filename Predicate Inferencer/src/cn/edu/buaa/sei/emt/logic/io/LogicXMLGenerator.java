package cn.edu.buaa.sei.emt.logic.io;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class LogicXMLGenerator {
	String name;
	Document doc;
	
	public LogicXMLGenerator(String name,Document doc){this.name=name;this.doc=doc;}
	
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
	
	Element generateProposition(PropositionVariable var){
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
		elm.setAttribute("id", var.getName());
		elm.setAttribute("name", var.getName());
		
		return elm;
	}
	Element generateVariable(Variable var){
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
		elm.setAttribute("id", var.getName());
		elm.setAttribute("name", var.getName());
		
		return elm;
	}
	Element generateDiscourseDomain(DiscourseDomain domain){
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
		elm.setAttribute("id", domain.getName());
		elm.setAttribute("name", domain.getName());
		
		if(domain.getIter()!=null){
			Element iter = doc.createElement(VAR_REF);
			iter.setAttribute("id", domain.getIter().getName());
			elm.appendChild(iter);
		}
		
		return elm;
	}

	Element generatePredicate(PredicateFormulation form){
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
