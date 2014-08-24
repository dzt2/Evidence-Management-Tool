package cn.edu.buaa.sei.emt.logic.creator;

import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Disjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Equivalence;
import cn.edu.buaa.sei.emt.logic.predicate.core.Implication;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.Negation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.Quantification;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class LogicModifier {
	
	/*
	 *	LogicModifier provides static functions for modify the attributes in logic formulation or values in variables 
	 */
	
	/*
	 *	Tool Functions 
	 * 
	 */
	static Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Logic Modifier reports errors: ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Formulation Modifier: change formulations
	 *	- setter/appender
	 *		Null formulation/variables [subject] cannot be modified.
	 *		Null [child] cannot be added/set in the subject.
	 *		The failure above only return false as a result (no exception)
	 *	- remover
	 *		Null child/items in subject cannot be removed.
	 *		Or throw exceptions.
	 *	
	 *	-only modify the attributes not values!
	 *	=================================================Modifier=============================================
	 *	1) modifyNegation(op,child)
	 *		note: op.formulation = child.
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: null child
	 *	2) modifyImplication(op,premise,conclusion)
	 *		note: [!premise]op.premise = premise; [!conclusion]op.conclusion = conclusion;
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: null premise && null conclusion
	 *	3) modifyEquivalence(op,f1,f2)
	 *		note: [!f1]op.formulation1=f1;[!f2]op.formulation2=f2;
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: null f1 && null f2
	 *	4) modifyQuantification(q,domain,scope)
	 *		note: [!domain]q.domain=domain;[!scope]q.scope=scope;
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: null domain && null scope
	 *	=================================================Appender=============================================
	 *	1) appendConjunction(op,child) [Disjunction]
	 *		note: [!child]op.children.add(child)
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: null child
	 *	2) appendPredicate(p,var)
	 *		note: [!var]p.variables.add(var);
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: null child
	 *	=================================================Remover==============================================
	 *	1) removeNegation(op)
	 *		note: op.formulation = null || modifyNegation(op,null) [roll back]
	 *		normal exceptions:
	 *			-ex1: null op;
	 *	2) removeImplication(op,premise,conclusion)
	 *		note: [premise]op.premise=null;[conclusion]op.conclusion=null;
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: !premise && !conclusion
	 *	3) removeEquivalence(op,f1,f2)
	 *		note: [f1]op.formulation1=null;[f2]op.formulation2=null;
	 *		normal exceptions:
	 *			-ex1: null op
	 *			-ex2: !f1 && !f2
	 *	4) removeQuantification(q,domain,scope)
	 *		note: [domain]q.domain=null;[scope]q.scope=null;
	 *		normal exceptions:
	 *			-ex1: null q
	 *			-ex2: !domain && !scope
	 *	5) removeConjunction(op,i) [Disjunction]
	 *		note: op.children.remove(i);
	 *		exceptions:
	 *			-ex1: null op
	 *			-ex2: i out of range
	 *	6) removePredicate(p,i)
	 *		note: p.variables.remove[i]
	 *		exceptions:
	 *			-ex1: null p
	 *			-ex2: i out of range
	 *
	 */
	public static Boolean modifyNegation(Negation op,LogicFormulation child){
		if(op==null||child==null)return false;
		op.setFormulation(child);
		return true;
	}
	public static Boolean modifyImplication(Implication op,LogicFormulation premise,
			LogicFormulation conclusion){
		if(op==null)return false;
		if(premise==null&&conclusion==null)return false;
		
		if(premise!=null)op.setPremise(premise);
		if(conclusion!=null)op.setConclusion(conclusion);
		return true;
	}
	public static Boolean modifyEquivalence(Equivalence op,LogicFormulation f1,LogicFormulation f2){
		if(op==null)return false;
		if(f1==null&&f2==null)return false;
		
		if(f1!=null)op.setFormulation1(f1);
		if(f2!=null)op.setFormulation2(f2);
		return true;
	}
	public static Boolean appendConjunction(Conjunction op,LogicFormulation child){
		if(op==null||child==null)return false;
		op.getFormulations().add(child);
		return true;
	}
	public static Boolean appendDisjunction(Disjunction op,LogicFormulation child){
		if(op==null||child==null)return false;
		op.getFormulations().add(child);
		return true;
	}
	public static Boolean modifyQuantification(Quantification q,DiscourseDomain domain,LogicFormulation scope){
		if(q==null)return false;
		if(domain==null&&scope==null)return false;
		
		if(domain!=null)q.setDomain(domain);
		if(scope!=null)q.setScope_formulation(scope);
		
		return true;
	}
	public static Boolean appendPredicate(PredicateFormulation p,Variable var){
		if(p==null||var==null)return false;
		p.getVariables().add(var);
		return true;
	}

	public static Boolean removeConjunction(Conjunction op,int i){
		if(op==null)return false;
		if(i<0||i>=op.getFormulations().size()){
			try {
				throw getArgException("i","removeConjunction(op,i)",
						"the "+i+" has out of range: size = "+op.getFormulations().size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		op.getFormulations().remove(i);
		return true;
	}
	public static Boolean removeDisjunction(Disjunction op,int i){
		if(op==null)return false;
		if(i<0||i>=op.getFormulations().size()){
			try {
				throw getArgException("i","removeDisjunction(op,i)",
						"the "+i+" has out of range: size = "+op.getFormulations().size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		op.getFormulations().remove(i);
		return true;
	}
	public static Boolean removeNegation(Negation op){
		if(op==null)return false;
		op.setFormulation(null);
		return true;
	}
	public static Boolean removeImplication(Implication op,Boolean premise,Boolean conclusion){
		if(op==null)return null;
		if(premise)op.setPremise(null);
		if(conclusion)op.setConclusion(null);
		return premise||conclusion;
	}
	public static Boolean removeEquivalence(Equivalence op,Boolean f1,Boolean f2){
		if(op==null)return false;
		if(f1)op.setFormulation1(null);
		if(f2)op.setFormulation2(null);
		return f1||f2;
	}
	public static Boolean removePredicate(PredicateFormulation p,int i){
		if(p==null)return false;
		if(i<0||i>=p.getVariables().size()){
			try {
				throw getArgException("i","removePredicate(op,i)",
						"the "+i+" has out of range: size = "+p.getVariables().size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		p.getVariables().remove(i);
		return true;
	}
	public static Boolean removeQuantification(Quantification q,Boolean domain, Boolean scope){
		if(q==null)return false;
		if(domain) q.setDomain(null);
		if(scope)q.setScope_formulation(null);
		return domain||scope;
	}
	
}
