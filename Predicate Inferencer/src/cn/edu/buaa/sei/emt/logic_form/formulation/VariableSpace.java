package cn.edu.buaa.sei.emt.logic_form.formulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationFactory;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;
import cn.edu.buaa.sei.lmf.Type;

public class VariableSpace {
	Map<String,Bindable> map = new HashMap<String,Bindable>();
	String space_name;
	
	public VariableSpace(String space_name){
		this.space_name=space_name;
	}
	public String getSpaceName(){return this.space_name;}
	
	/*
	 *	Utility Functions
	 *		1. prepare_create: verify the name used before creating variables
	 *		2. getArgError: generate errors for 
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
	
	/*
	 *	Reader Functions
	 *		1. containVariable: verify whether the name has been defined.
	 *		2. getVariable: get the variable by name
	 *		3. getVariableType: get the type of the variable
	 *		4. removeVariable: remove the variable from space and return it. 
	 */
	public boolean containVariable(String name){return this.map.containsKey(name);}
	public Bindable getVariable(String name){return this.map.get(name);}
	public Type getVariableType(String name){
		if(this.map.containsKey(name))
			return this.map.get(name).type();
		return null;
	}
	public Bindable removeVariable(String name){
		if(this.map.containsKey(name))
			return this.map.remove(name);
		try {
			throw this.getArgError("name", "removeVariable", "try to remove un-defined Bindable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return null;
	}
	public Set<String> getNames(){return this.map.keySet();}
	
	/*
	 *	Creator Functions
	 *		1. createVariable(String name)
	 *		2. createDiscourseDomain(String name);
	 *		3. createPredicateFormulation(String name,List<Variable>);
	 * 		4. createPropositionVariable(String name);
	 */
	public Variable createVariable(String name){
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		Variable var = LogicFormulationFactory.createVariable();
		var.setName(name);
		
		this.map.put(name, var);
		return var;
	}
	public DiscourseDomain createDiscourseDomain(String name){
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		
		DiscourseDomain domain = LogicFormulationFactory.createDiscourseDomain();
		domain.setName(name);
		Variable var = LogicFormulationFactory.createVariable();
		var.setName(name+".iter");
		domain.setIter(var);
		
		this.map.put(name, domain);
		return domain;
	}
	public PredicateFormulation createPredicateFormulation(String name,List<Variable> vars){
		/*
		 *	Verify possible faults:
		 *		1. name conflict
		 *		2. null vars
		 *		3. empty vars 
		 */
		try {
			this.prepare_creat(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
		if(vars==null){
			try {
				throw this.getArgError("vars", "createPredicateFormulation", 
						"createPredicateFormulation("+name+", null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		if(vars.isEmpty()){
			try {
				throw this.getArgError("vars", "createPredicateFormulation", 
						"createPredicateFormulation("+name+", empty_set)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		// create predicate formulation
		PredicateFormulation predicate = LogicFormulationFactory.createPredicateFormulation();
		predicate.setName(name);
		
		for(Variable var:vars)
			if(var!=null)
				predicate.getVariables().add(var);
		
		this.map.put(name, predicate);
		return predicate;
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
	
	
}
