package cn.edu.buaa.sei.emt.logic_form.formulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Disjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Equivalence;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.Implication;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationFactory;
import cn.edu.buaa.sei.emt.logic.predicate.core.Negation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;
import cn.edu.buaa.sei.lmf.ManagedObject;
import cn.edu.buaa.sei.lmf.Type;

public class LogicSpace {
	protected Map<String,LogicFormulation> map = new HashMap<String,LogicFormulation>();
	String space_name;
	
	public LogicSpace(String space_name){
		this.space_name = space_name;
	}
	public String getSpaceName(){return this.space_name;}
	
	/*
	 * 	void prepare_creat(string name) ==> check whether the name has been used to link an object.
	 * 	Boolean containObject(ManagedObject obj) ==> check whether the object has been imported in the space
	 * 	String getTemporaryName(ManagedObject obj) ==> return a temporary name for storing unimported object.
	 * 
	 */
	void prepare_creat(String name) throws Exception{
		if(this.map.containsKey(name)){
			StringBuilder msg = new StringBuilder();
			msg.append("Error Type: Name Conflict\n");
			msg.append("Conflict Name: "+name + "\n");
			Type type = this.map.get(name).type();
			msg.append("Reason: Variable "+name+"["+type.getFullName()+"] has been defined.");
			throw new Exception(msg.toString());
		}
	}
	Exception getArgError(String name, String function, String reason){
		StringBuilder msg = new StringBuilder();
		msg.append("Error Type: Argument Errors\n");
		msg.append("Location: "+function+"\n");
		msg.append("Error Argument: "+name+"\n");
		//msg.append("Conflict Name: "+name + "\n");
		//Type type = this.map.get(name).type();
		msg.append("Reason: "+reason);
		return new Exception(msg.toString());
	}
	String getTemporaryName(ManagedObject obj){
		if(obj==null)return null;
		return obj.type().getFullName()+"["+obj.hashCode()+"]";
	}
	
	Boolean containFormulation(LogicFormulation obj){
		return this.map.containsValue(obj);
	}
	
	/*
	 *	Getter Functions 
	 */
	public LogicFormulation getFormulation(String name){
		return this.map.get(name);
	}
	public Type getFormulationType(String name){
		if(this.map.containsKey(name))
			return this.map.get(name).type();
		return null;
	}
	public LogicFormulation removeFormulation(String name){
		return this.map.remove(name);
	}
	public Set<String> getNames(){return this.map.keySet();}
	
	
	/*
	 *	create functions
	 *		Conjunction, Disjunction, Negation, Implication, Equivalence
	 *		PropositionVariable, PredicateFormulation 
	 * 		Universal, Existential.
	 * 
	 */
	
	public LogicExpression createConjunction(String name,Set<LogicFormulation> formulations){
		/*
		 *	Check three possible faults:
		 *		1) name conflicts
		 *		2) argument null
		 *		3) formulations is empty 
		 */
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		if(formulations==null){
			try {
				throw this.getArgError("formulations","createConjunction",
						"createConjunction("+name+","+"null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		if(formulations.isEmpty()){
			try {
				throw this.getArgError("formulations","createConjunction",
						"createConjunction("+name+","+"empty_set)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		/*
		 *	Creating logic expression and conjunction. 
		 */
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		expr.setName(name);
		Conjunction op = LogicFormulationFactory.createConjunction();
		expr.setOperator(op);
		
		for(LogicFormulation formulation:formulations)
			if(formulation!=null){
				/*if(!this.containObject(formulation))
					this.map.put(this.getTemporaryName(formulation), formulation);*/
				op.getFormulations().add(formulation);
			}
		
		this.map.put(name,expr);
		
		return expr;
	}
	
	public LogicExpression createDisjunction(String name,Set<LogicFormulation> formulations){
		/*
		 *	Check three possible faults:
		 *		1) name conflicts
		 *		2) argument null
		 *		3) formulations is empty 
		 */
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		if(formulations==null){
			try {
				throw this.getArgError("formulations","createDisjunction",
						"createDisjunction("+name+","+"null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		if(formulations.isEmpty()){
			try {
				throw this.getArgError("formulations","createDisjunction",
						"createDisunction("+name+","+"empty_set)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		/*
		 *	Creating logic expression and disjunction 
		 */
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		expr.setName(name);
		Disjunction op = LogicFormulationFactory.createDisjunction();
		expr.setOperator(op);
		
		for(LogicFormulation formulation:formulations)
			if(formulation!=null){
				/*if(!this.containObject(formulation)){
					String tname = this.getTemporaryName(formulation);
					formulation.setName(tname);
					this.map.put(tname, formulation);
				}*/
				op.getFormulations().add(formulation);
			}
		
		this.map.put(name,expr);
		return expr;
	}

	public LogicExpression createNegation(String name,LogicFormulation formulation){
		/*
		 *	Verify two possible faults:
		 *		1) name conflicts
		 *		2) argument null 
		 */
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		if(formulation==null){
			try {
				throw this.getArgError("formulation","createNegation",
						"createNegation("+name+","+"null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		/*
		 *	Creating logic expression and negation. 
		 */
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		expr.setName(name);
		Negation op = LogicFormulationFactory.createNegation();
		expr.setOperator(op);
		
		/*if(!this.map.containsValue(formulation)){
			String tname = this.getTemporaryName(formulation);
			formulation.setName(tname);
			this.map.put(tname, formulation);
		}*/
		op.setFormulation(formulation);
		
		this.map.put(name, expr);
		return expr;
	}
	
	public LogicExpression createImplication(String name, LogicFormulation premise, LogicFormulation conclusion){
		/*
		 *	Verify three possible bugs:
		 *		1) name conflicts
		 *		2) argument premise null
		 *		3) argument conclusion null 
		 * 
		 */
		
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		if(premise==null){
			try {
				throw this.getArgError("premise","createImplication",
						"createImplication("+name+", "+premise+", "+conclusion+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		if(conclusion==null){
			try {
				throw this.getArgError("conclusion","createImplication",
						"createImplication("+name+", "+premise+", "+conclusion+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		// create logic expression and implication
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		expr.setName(name);
		Implication op = LogicFormulationFactory.createImplication();
		expr.setOperator(op);
		
		op.setPremise(premise);
		op.setConclusion(conclusion);
		
		this.map.put(name, expr);
		return expr;
	}
	
	public LogicExpression createEquivalence(String name,LogicFormulation f1,LogicFormulation f2){
		/*
		 *	Verify three possible bugs:
		 *		1) name conflicts
		 *		2) argument f1 null
		 *		3) argument f2 null 
		 * 
		 */
		
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		if(f1==null){
			try {
				throw this.getArgError("f1", "createEquivalence", 
						"createEquivalence("+name+", "+f1+", "+f2+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		if(f2==null){
			try {
				throw this.getArgError("f2", "createEquivalence", 
						"createEquivalence("+name+", "+f1+", "+f2+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		// create logic expression and Equivalence
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		expr.setName(name);
		Equivalence op = LogicFormulationFactory.createEquivalence();
		expr.setOperator(op);
		
		op.setFormulation1(f1);op.setFormulation2(f2);
		
		this.map.put(name, expr);
		return expr;
		
	}

	
	public PropositionVariable createPropositionVariable(String name){
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		// create proposition variable
		PropositionVariable var = LogicFormulationFactory.createPropositionVariable();
		var.setName(name);
		
		this.map.put(name, var);
		return var;
	}
	
	public PredicateFormulation createPredicateFormulation(String name,List<Variable> variables){
		/*
		 *	Verify three possible faults:
		 *		1) name conflicts
		 *		2) variables null
		 *		3) variables empty 
		 */
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		if(variables==null){
			try {
				throw this.getArgError("variables", "createPredicateFormulation", 
						"createPredicate("+name+", null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		if(variables.isEmpty()){
			try {
				throw this.getArgError("variables", "createPredicateFormulation", 
						"createPredicate("+name+", empty_set)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		// create predicate formulation and variables
		PredicateFormulation predicate = LogicFormulationFactory.createPredicateFormulation();
		predicate.setName(name);
		
		for(Variable var:variables)
			if(var!=null)
				predicate.getVariables().add(var);
		
		this.map.put(name, predicate);
		return predicate;
	}

	public Universal createUniversal(String name,DiscourseDomain domain,LogicFormulation scope){
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		if(domain==null){
			try {
				throw this.getArgError("domain", "createUniversal", 
						"createUniversal("+name+", null, scope)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		if(scope==null){
			try {
				throw this.getArgError("scope", "createUniversal", 
						"createUniversal("+name+", domain, null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		// create Universal, domain and scope
		Universal expr = LogicFormulationFactory.createUniversal();
		expr.setName(name);
		expr.setDomain(domain);
		expr.setScope_formulation(scope);
		
		this.map.put(name, expr);
		return expr;
	}
	
	public Existential createExistential(String name,DiscourseDomain domain,LogicFormulation scope){
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		if(domain==null){
			try {
				throw this.getArgError("domain", "createExistential", 
						"createExistential("+name+", null, scope)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		if(scope==null){
			try {
				throw this.getArgError("scope", "createExistential", 
						"createExistential("+name+", domain, null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		// create Existential, domain and scope
		Existential expr = LogicFormulationFactory.createExistential();
		expr.setName(name);
		expr.setDomain(domain);
		expr.setScope_formulation(scope);
		
		
		this.map.put(name, expr);
		return expr;
	}
	
	/*
	 *	Assignment Functions:
	 *		1. assignPropositionVariable(String name, BooleanObject);
	 *		2. assignPredicateFormulation(String name, LRelations);
	 *		3. assignPredicateVariables(String name, List<Variable>);
	 */
	void assignPropositionVariable(String name,BooleanObject value){
		if(!this.map.containsKey(name)){
			try {
				throw this.getArgError("name", "assignPropositionVariable", 
						"Undefined Variable: "+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		
		LogicFormulation var = this.map.get(name);
		
		if(var instanceof PropositionVariable){
			((PropositionVariable) var).setValue(value);
			((PropositionVariable) var).setObject(value);
			((PropositionVariable) var).setT_value(value);
		}
		else{
			try {
				throw this.getArgError("value", "assignPropositionVariable", 
						"Type Errors, Requires "+name+" PropositionVariable.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		
		
	}
	void assignPredicateVariables(String name,List<LObject> args){
		/*
		 * 	Verify possible faults:
		 * 		1. Undefined Name
		 * 		2. Null Args
		 * 		3. Empty argument list
		 * 
		 */
		if(!this.map.containsKey(name)){
			try {
				throw this.getArgError("name", "assignPredicateVariables", 
						"Undefined Variable: "+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		if(args==null){
			try {
				throw this.getArgError("args", "assignPredicateVariables", 
						"try to call assignPredicateVariables("+name+", null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		if(args.isEmpty()){
			try {
				throw this.getArgError("args", "assignPredicateVariables", 
						"try to call assignPredicateVariables("+name+", empty_set)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		
		// assignment
		LogicFormulation var = this.map.get(name);
		if(var instanceof PredicateFormulation){
			List<Variable> vars = ((PredicateFormulation) var).getVariables();
			if(vars.size()!=args.size()){
				try {
					throw this.getArgError("args", "assignPredicateVariables", 
							"Length of Argument Match Failure");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
					return;
				}
			}
			
			for(int i=0;i<args.size();i++){
				Variable vi = vars.get(i);
				LObject vali = args.get(i);
				vi.setValue(vali);
				vi.setObject(vali);
			}
			
		}
		else{
			try {
				throw this.getArgError("name", "assignPredicateVariables", 
						"Type Errors, Requires "+name+" PredicateFormulation.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		
		
	}
	void assignPredicateFormulation(String name,LRelationSet relations){
		/*
		 * 	Verify possible faults:
		 * 		1. Undefined Name
		 * 		2. Null relations
		 * 		3. Empty relations
		 * 
		 */
		if(!this.map.containsKey(name)){
			try {
				throw this.getArgError("name", "assignPredicateFormulation", 
						"Undefined Variable: "+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		if(relations==null){
			try {
				throw this.getArgError("relations", "assignPredicateFormulation", 
						"call assignPredicate("+name+", null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		if(relations.getRelations().isEmpty()){
			try {
				throw this.getArgError("relations", "assignPredicateFormulation", 
						"call assignPredicate("+name+", empty_set)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
		
		// assignment
		LogicFormulation var =  this.getFormulation(name);
		if(var instanceof PredicateFormulation){
			((PredicateFormulation) var).setValue(relations);
			((PredicateFormulation) var).setAssociated_relations(relations);
		}
		else{
			try {
				throw this.getArgError("name", "assignPredicateFormulation", 
						"Type Errors, Requires "+name+" PredicateFormulation.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return;
			}
		}
	}
	
}
