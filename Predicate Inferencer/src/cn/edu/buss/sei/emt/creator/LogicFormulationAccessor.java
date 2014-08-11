package cn.edu.buss.sei.emt.creator;

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

public class LogicFormulationAccessor {
	
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
	
	
	static Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Type: Argument Errors: ");
		code.append("argument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	static String[] getSubNames(String name){
		if(name==null)return null;
		if(!name.contains("."))return new String[]{name};
		String[] paths = new String[2];
		int index = name.indexOf(".");
		paths[0] = name.substring(0,index);
		if(index<name.length())paths[1] = name.substring(index+1);
		else paths[1]=null;
		return paths;
	}
	static LogicFormulation getChildFormulations(String name,List<LogicFormulation> forms){
		if(name==null||forms==null)return null;
		
		for(LogicFormulation form:forms)
			if(name.equals(form.getName()))
				return form;
		
		if(name.startsWith(ARG_PREFIX)){
			String id = name.substring(ARG_PREFIX.length());
			try{
				Integer i = Integer.parseInt(id);
				if(i<0||i>forms.size())
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
		if(name==null||vars==null)return null;
		
		for(Variable var:vars)
			if(name.equals(var.getName()))
				return var;
		
		if(name.startsWith(ARG_PREFIX)){
			String id = name.substring(ARG_PREFIX.length());
			try{
				Integer i = Integer.parseInt(id);
				if(i<0||i>vars.size())
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
	
	static Object getNextInPredicate(String name,PredicateFormulation form){
		if(name==null||form==null)return null;
		
		if(name.equals(PREDICATE_RELATIONS)||name.equals(BIND_VALUE))
			return form.getAssociated_relations();
		
		return getChildVariables(name,form.getVariables());
	}
	
	static LogicFormulation getNextInLogicExpression(String name,LogicExpression expr){
		if(name==null||expr==null)return null;
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
		return getChildFormulations(name,op.getFormulations());
	}
	static LogicFormulation getNextInDisjunction(String name,Disjunction op){
		return getChildFormulations(name,op.getFormulations());
	}
	static LogicFormulation getNextInNegation(String name,Negation op){
		if(name==null||op==null)return null;
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
		if(name==null||impl==null)return null;
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
		if(name==null||op==null)return null;
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
		if(name==null||q==null)return null;
		
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
		if(name==null||var==null)return null;
		if(name.equals(BIND_VALUE))return var.getValue();
		else return null;
	}
	static Object getNextInDiscourseDomain(String name,DiscourseDomain domain){
		if(name==null||domain==null)return null;
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
		if(name==null||var==null)return null;
		
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
		if(name==null||var==null)return null;
		
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
		if(path==null||form==null)return form;
		
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
