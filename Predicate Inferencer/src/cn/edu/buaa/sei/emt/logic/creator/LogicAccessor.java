package cn.edu.buaa.sei.emt.logic.creator;

import java.util.List;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
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
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class LogicAccessor {
	/*
	 *	This class provide only static functions and interfaces. 
	 *	Using name to search object in a logic formulation:
	 *	1) Conjunction/Disjunction:
	 *		-children[i]: children[i].name / "_arg"+i
	 *	2) Negation
	 *		-child: child.name / "child"
	 *	3) Implication:
	 *		-premise: premise.name / "premise"
	 *		-conclusion: conclusion.name / "conclusion"
	 *	4) Equivalence:
	 *		-formulation1: formulation1.name / "form1"
	 *		-formulation2: formulation2.name / "form2"
	 *	5) Quantification:
	 *		-domain: domain.name / "domain"
	 *		-scope: scope.name / "scope"
	 *	6) PropositionVariable
	 *		-t_value <value/object>: "t_value" / "object" / "value"
	 *	7) Variable
	 *		-object <value>: "object" / "value"
	 *		
	 *
	 */
	
	public static final String SPLIT = ".";
	
	public static final String ARG_PREFIX = "_arg";
	public static final String NEG_CHILD = "child";
	public static final String IMPL_PREMISE = "premise";
	public static final String IMPL_CONCLUSION = "conclusion";
	public static final String EQ_F1 = "form1";
	public static final String EQ_F2 = "form2";
	public static final String Q_DOMAIN = "domain";
	public static final String Q_SCOPE = "scope";
	
	
	public static final String BIND_VALUE = "value";
	public static final String VAR_OBJECT = "object";
	public static final String DOMAIN_ITOR="iter";
	public static final String DOMAIN_SET = "set";
	public static final String PROPOSITION_TVALUE = "t_value";
	public static final String PREDICATE_RELATIONS = "relations";
	
	/*
	 *	Tool Functions 
	 *	=======================================================================================
	 *	1. static getArgException(args,func,reason)
	 *	2. getChildFormulation(name,forms)
	 *		note: return var (in forms); which: var.name = name || "_arg"+var.index = name
	 *		exceptions:
	 *			-ex1: unexistence name in forms
	 *			-ex2: _arg[invalid number] --> number < 0 or number >= form.size()
	 *			-ex3: name==null||forms==null: return null;
	 *		example:
	 *			forms = [A,B,C]
	 *			valid_names = {A,B,C,_arg0,_arg1,_arg2}
	 *	3. getChildVariable(name, vars)
	 *		as above
	 */
	static Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Logic Accessor reports errors: ");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	/*static String[] getSubNames(String name){
		if(name==null)return null;
		if(!name.contains("."))return new String[]{name};
		String[] paths = new String[2];
		int index = name.indexOf(".");
		paths[0] = name.substring(0,index);
		if(index<name.length())paths[1] = name.substring(index+1);
		else paths[1]=null;
		return paths;
	}*/
	static LogicFormulation getChildFormulations(String name,List<LogicFormulation> forms){
		if(name==null||forms==null){
			try {
				throw getArgException("name|forms","getChildFormulations(name,forms)","Invalid arguments");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		for(LogicFormulation form:forms)
			if(name.equals(form.getName()))
				return form;
		
		if(name.startsWith(ARG_PREFIX)){
			String id = name.substring(ARG_PREFIX.length()).trim();
			try{
				Integer i = Integer.parseInt(id);
				if(i<0||i>=forms.size())
					throw getArgException("name","getChildFormulation",
							"Invalid Argument Index ["+id+"] out of range: "+forms.size());
				return forms.get(i);
			}
			catch(Exception e){
				try {
					throw getArgException("name","getChildFormulation",
							"Invalid Variable Name {"+name+"}");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return null;
	}
	static Variable getChildVariables(String name,List<Variable> vars){
		if(name==null||vars==null){
			try {
				throw getArgException("name|forms","getChildVariables(name,forms)","Invalid arguments");
			} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return null;
		}
		
		for(Variable var:vars)
			if(name.equals(var.getName()))
				return var;
		
		if(name.startsWith(ARG_PREFIX)){
			String id = name.substring(ARG_PREFIX.length());
			try{
				Integer i = Integer.parseInt(id);
				if(i<0||i>=vars.size())
					throw getArgException("name","getChildVariables",
							"Invalid Argument Index ["+id+"] out of range: "+vars.size());
				return vars.get(i);
			}
			catch(Exception e){
				try {
					throw getArgException("name","getChildVariables",
							"Invalid Variable Name {"+name+"}");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/*
	 *	Search in next item
	 *	1) getNextInPredicate(name,form)
	 *		note: 
	 *			[1] name = "relations" || name = "value" --> 
	 *				return form.getAssociatedRelation/getValue() == same
	 *			[2] name = form.variables[i].name || "_arg"+<index>	
	 *				return form.variables[i]
	 *		exceptions:
	 *			-ex1: null name
	 *			-ex2: null form
	 *			-ex3: unexist children name <value|variables>
	 *	2) getNextInConjunction(name,op) [Disjunction]
	 *		note:
	 *			[1] children: name = op.children[i].name || name = "_arg"+<index>;
	 *		exceptions:
	 *			-ex1: null name
	 *			-ex2: null op
	 *			-ex3: unexist name <children name>
	 *	3) getNextInNegation(name,op)
	 *		note:
	 *			[1] child: name = op.child.name || "child"
	 *		exceptions:
	 *			-ex1: null name
	 *			-ex2: null op
	 *			-ex3: unexist name <child>
	 *	4) getNextInImplication(name,op) <Equivalence>
	 *		note:
	 *			[1] premise: name = "premise" || name = op.premise.name
	 *			[2] conclusion: name = "conclusion" || name = op.conclusion.name
	 *		exceptions:
	 *			-ex1: null name
	 *			-ex2: null op
	 *			-ex3: null children state (premise==null&&conclusion==null)
	 *			-ex4: unexist name
	 * 	5) getNextInEquivalence(name,op)
	 * 		note:
	 * 			[1]formulation1: name = "form1" || name = op.formulation1.name
	 * 			[2]formulation2: name = "form2" || name = op.formulation2.name
	 * 	6) getNextInQuantification(name,q)
	 * 		note:
	 * 			[1]q.domain: name = "domain" || name = q.domain.name
	 * 			[2]q.scope:	 name = "scope"  || name = q.scope.name
	 * 
	 * 	7) getNextInBindable(name,var)
	 * 		note:
	 * 			[1]var.value: name == "value"
	 * 	8) getNextInVariable(name,var)
	 * 		note:
	 * 			[1]var.value: name = "value" || name = "object"
	 * 	9) getNextInPropositionVariable(name,var)
	 * 		note:
	 * 			[1]var.value: name = "value" || name = "object" || name = "t_value"
	 * 	10) getNextInDiscourseDomain(name,domain)
	 * 		note:
	 * 			[1] domain.iter: name = "iter" || name = domain.iter.name [domain.name+"_iter"]
	 * 			[2] domain.set: name = "value" || name = "set"
	 */
	static Object getNextInPredicate(String name,PredicateFormulation form){
		if(name==null||form==null){
			try {
				throw getArgException("name|form","getNextInPredicate(name,form)","Invalid arguments");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		if(name.equals(PREDICATE_RELATIONS)||name.equals(BIND_VALUE))
			return form.getAssociated_relations();
		
		return getChildVariables(name,form.getVariables());
	}
	static LogicFormulation getNextInLogicExpression(String name,LogicExpression expr){
		if(name==null||expr==null){
			try {
				throw getArgException("name|expr","getNextInLogicExpression(name,expr)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		LogicOperator op = expr.getOperator();
		
		if(op instanceof Conjunction){
			return getNextInConjunction(name,(Conjunction) op);
		}
		else if(op instanceof Disjunction){
			return getNextInDisjunction(name,(Disjunction) op);
		}
		else if(op instanceof Negation){
			return getNextInNegation(name,(Negation) op);
		}
		else if(op instanceof Implication){
			return getNextInImplication(name,(Implication) op);
		}
		else if(op instanceof Equivalence){
			return getNextInEquivalence(name,(Equivalence) op);
		}
		return null;
	}
	static LogicFormulation getNextInConjunction(String name,Conjunction op){
		if(name==null||op==null){
			try {
				throw getArgException("name|op","getNextInConjunction(name,op)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return getChildFormulations(name,op.getFormulations());
	}
	static LogicFormulation getNextInDisjunction(String name,Disjunction op){
		if(name==null||op==null){
			try {
				throw getArgException("name|op","getNextInDisjunction(name,op)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		return getChildFormulations(name,op.getFormulations());
	}
	static LogicFormulation getNextInNegation(String name,Negation op){
		if(name==null||op==null){
			try {
				throw getArgException("name|op","getNextInNegation(name,op)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(NEG_CHILD))return op.getFormulation();
		if(op.getFormulation()!=null&&name.equals(op.getFormulation().getName()))
			return op.getFormulation();
		
		if(op.getFormulation()!=null){
			try {
				throw getArgException("name","getNextInNegation",
						"Invalid Search Name {"+name+"} In Negation -- Required \""+op.getFormulation().getName()+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				throw getArgException("op","getNextInNegation","Negation include a null child");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	static LogicFormulation getNextInImplication(String name,Implication impl){
		if(name==null||impl==null){
			try {
				throw getArgException("name|op","getNextInImplication(name,op)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(IMPL_PREMISE))return impl.getPremise();
		if(name.equals(IMPL_CONCLUSION))return impl.getConclusion();
		
		if(impl.getPremise()!=null&&name.equals(impl.getPremise().getName()))
			return impl.getPremise();
		if(impl.getConclusion()!=null&&name.equals(impl.getConclusion()))
			return impl.getConclusion();
		
		if(impl.getPremise()==null&&impl.getConclusion()==null){
			try {
				throw getArgException("impl","getNextInImplication","Implication include a null child");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				if(impl.getPremise()!=null)
					throw getArgException("name","getNextInImplication",
						"Invalid Search Name {"+name+"} In Implication -- Required \""+IMPL_PREMISE+"\"");
				else
					throw getArgException("name","getNextInImplication",
							"Invalid Search Name {"+name+"} In Implication -- Required \""+IMPL_CONCLUSION+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	static LogicFormulation getNextInEquivalence(String name,Equivalence op){
		if(name==null||op==null){
			try {
				throw getArgException("name|op","getNextInEquivalence(name,op)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name.equals(EQ_F1))return op.getFormulation1();
		if(name.equals(EQ_F2))return op.getFormulation2();
		if(op.getFormulation1()!=null&&name.equals(op.getFormulation1().getName()))
			return op.getFormulation1();
		if(op.getFormulation2()!=null&&name.equals(op.getFormulation2().getName()))
			return op.getFormulation2();
		
		if(op.getFormulation1()==null&&op.getFormulation2()==null){
			try {
				throw getArgException("op","getNextInEquivalence",
						"Equivalence include both null children");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				throw getArgException("name","getNextInEquivalence",
						"Invalid Name \""+name+"\" -- Required in {\""+EQ_F1+"\", \""+EQ_F2+"\"}");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	static Object getNextInQuantification(String name,Quantification q){
		if(name==null||q==null){
			try {
				throw getArgException("name|op","getNextInQuantification(name,q)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(Q_DOMAIN ))return q.getDomain();
		if(name.equals(Q_SCOPE))return q.getScope_formulation();
		
		if(q.getDomain()!=null&&name.equals(q.getDomain().getName()))return q.getDomain();
		if(q.getScope_formulation()!=null&&name.equals(q.getScope_formulation().getName()))
			return q.getScope_formulation();
		
		if(q.getDomain()==null||q.getScope_formulation()==null){
			try {
				throw getArgException("op","getNextInQuantification",
						"Quantification include null domain and null scope formulation!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				throw getArgException("name","getNextInEquivalence",
						"Invalid Name \""+name+"\" -- Required in {\""+Q_DOMAIN+
						"\", \""+Q_SCOPE+"\"}");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	static Value getNextInBindable(String name,Bindable var){
		if(name==null||var==null){
			try {
				throw getArgException("name|var","getNextInBindable(name,var)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(BIND_VALUE))return var.getValue();
		else{
			try {
				throw getArgException("name","getNextInBindable(name,var)","Undefined name: "+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	static Object getNextInDiscourseDomain(String name,DiscourseDomain domain){
		if(name==null||domain==null){
			try {
				throw getArgException("name|var","getNextInDiscourseDomain(name,domain)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(DOMAIN_ITOR))
			return domain.getIter();
		if(domain.getIter()!=null&&name.equals(domain.getIter().getName()))
			return domain.getIter();
		
		if(name.equals(DOMAIN_SET)||name.equals(BIND_VALUE))
			return domain.getSet();
		
		try {
			throw getArgException("name","getNextInBindable","Invalid Name \""+name+"\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	static Value getNextInVariable(String name,Variable var){
		if(name==null||var==null){
			try {
				throw getArgException("name|var","getNextInVariable(name,var)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(BIND_VALUE)||name.equals(VAR_OBJECT))
			return var.getObject();
		
		try {
			throw getArgException("name","getNextInVariable","Invalid Name \""+name+"\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	static BooleanObject getNextInPropositionVariable(String name,PropositionVariable var){
		if(name==null||var==null){
			try {
				throw getArgException("name|var","getNextInPropositionVariable(name,var)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		if(name.equals(BIND_VALUE)||name.equals(VAR_OBJECT)||name.equals(PROPOSITION_TVALUE))
			return var.getT_value();
		
		try {
			throw getArgException("name","getNextInPropositionVariable",
					"Invalid Name \""+name+"\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object getElementByName(String path,LogicFormulation form){
		if(path==null||form==null){
			try {
				throw getArgException("path||form","getElementByName(path,form)","Invalid argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return form;
		}
		
		String[] paths = path.split("\\.");
		String name = paths[0];
		
		if(!name.equals(form.getName())){
			try {
				throw getArgException("path","getElementByName","Invalid Path \""+path+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			Object obj = form;
			for(int i=1;i<paths.length;i++){
				name = paths[i];
				if(obj instanceof LogicExpression)
					obj = getNextInLogicExpression(name,(LogicExpression) obj);
				else if(obj instanceof Quantification)
					obj = getNextInQuantification(name,(Quantification) obj);
				else if(obj instanceof PropositionVariable)
					obj = getNextInPropositionVariable(name,(PropositionVariable) obj);
				else if(obj instanceof Variable)
					obj = getNextInVariable(name,(Variable) obj);
				else if(obj instanceof DiscourseDomain)
					obj = getNextInDiscourseDomain(name,(DiscourseDomain) obj);
				else if(obj instanceof PredicateFormulation)
					obj = getNextInPredicate(name,(PredicateFormulation) obj);
				else obj = null;
				
				if(obj==null){
					try {
						throw getArgException("path","getElementByName",
								"Out of Range at Path["+i+"]: \""+paths[i]+"\"");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// Cutting Off in the leaf object
				if(obj instanceof Value){
					if(i<paths.length-1){
						try {
							throw getArgException("path","getElementByName",
									"Out of Index at Path["+i+"]: \""+paths[i]+"\"");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.err.println(e.getMessage());
						}
					}
					return obj;
				}
			}
			return obj;
		}
		return null;
	}
}
