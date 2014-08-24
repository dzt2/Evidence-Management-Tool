package cn.edu.buaa.sei.emt.logic.creator;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Conjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Disjunction;
import cn.edu.buaa.sei.emt.logic.predicate.core.Equivalence;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.Implication;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationFactory;
import cn.edu.buaa.sei.emt.logic.predicate.core.Negation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;
import cn.edu.buaa.sei.lmf.ManagedObject;

public class LogicCreator {
	String creator_name;
	Map<String,LogicFormulation> form_map = new HashMap<String,LogicFormulation>();
	Map<String,Bindable> var_map = new HashMap<String,Bindable>();
	
	public LogicCreator(String creator_name){
		this.creator_name = creator_name;
	}
	
	/*
	 *	Tool Functions 
	 *		1) getArgException(args,func,reason): return exception to report errors in code.
	 *			args: the fault argument names.
	 *			func: the function where faults happened.
	 *			reason: what is the fault
	 *			return: XXX <name> report errors:  argument <args> in function <func>. Reason: <reason>
	 *		2) getNewID(obj)
	 *			obj: a ManagedObject (LMF Domain-model instance)
	 *			return: obj.type[<obj.hashCode+current_time>]
	 *			exceptions:
	 *				-ex1: obj = null
	 *			Note: this function return ID for any object for one time, 
	 *			and be used for generate a random ID for each object of LMF.
	 *			It cannot be called by other creator functions directly.
	 *		3) getNextID(obj,space)
	 *			obj: a ManagedObject (LMF Domain-model instance)
	 *			space: a map<String,ManagedObject>, it contains the pair of ID and its object.
	 *			return: the next new ID of a given object.
	 *			exceptions:
	 *				-ex1: if the times to try new ID by getNewID(obj) more than MAX_ID_TIMES
	 *			Note: this function try to generate new ID for an instance for at most MAX_ID_TIMES
	 *			or until it, report errors -- the ID space has been used out. It can be directly 
	 *			used by other creator functions.
	 *
	 */
	static final int MAX_ID_TIMES = 16;
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Logic Creator "+creator_name+" report errors");
		//code.append("\nType: Argument Errors: ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	String getNewID(ManagedObject obj){
		if(obj==null){
			try {
				throw this.getArgException("obj", "getNewID(ManagedObject obj)", 
						"Invalid Input: null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		StringBuilder id = new StringBuilder();
		long code = obj.hashCode() + Calendar.getInstance().getTimeInMillis();
		id.append(obj.type().getSimpleName()+"["+code+"]");		
		return id.toString();
	}
	@SuppressWarnings("rawtypes")
	String getNextID(ManagedObject obj,Map space) throws Exception{
		for(int i=0;i<MAX_ID_TIMES;i++){
			String id = this.getNewID(obj);
			if(!space.containsKey(id))
				return id;
		}
		
		throw this.getArgException("obj", "getNextID", "Name Space used out!");
	}
	
	/*
	 *	Setter & Getter Functions
	 *		1) form_map<String,LogicFormulation>: manage logic formulations
	 *			LogicExpression [Conjunction,Disjunction,Negation,Implication,Equivalence]
	 *			Quantification  [Universal,Existential]
	 *		2) var_map<String,LogicFormulation>: manage variables in formulation
	 *			Variable, PropositionVariable
	 *			PredicateFormulation [variables]
	 *			DiscourseDomain [iter:Variable]
	 *		3) Un-exception thrown functions:
	 *			getName()
	 *			getFormulationNames()
	 *			getBindableName()
	 *		4) Exception thrown functions:
	 *			a. getFormulation(name)
	 *				exceptions:
	 *					-ex1: !this.form_map.contain(name) --> try to access un_defined formulation
	 *			b. getBindable(name)
	 *				exceptions:
	 *					-ex1: !this.var_map.contain(name) --> try to access un_defined variable
	 *			c. putFormulation(name,form)
	 *				note: the function would put the name(ID) and form into form_map to be managed,
	 *				while the old name(conflict) would be overwritten
	 *				exception:
	 *					-ex1: null name
	 *					-ex2: null form
	 *			d. putBindable(name,var)
	 *				note: the function would put the name(ID) and form into var_map to be managed,
	 *				while the old name(conflict) would be overwritten
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: null var
	 *			e. removeFormulation(name)/removeBindable(name)
	 *				note: the function would remove by using the reference ID (name)
	 *				exceptions:
	 *					-ex1: !this.form_map.contain(name)
	 *						  !this.var_map.contain(name)
	 *						  undefined formulation/variable cannot be removed from the creator space.
	 *			d. clear()
	 *				note: clear the form_map & var_map.
	 *
	 *
	 */
	public String getName(){return this.creator_name;}
	public Set<String> getFormulationNames(){return this.form_map.keySet();}
	public Set<String> getBindableNames(){return this.var_map.keySet();}
	public LogicFormulation getFormulation(String name){
		if(this.form_map.containsKey(name))
			return this.form_map.get(name);
		else{
			try {
				throw this.getArgException("name", "getFormulation", 
						"There is no formulation with name \""+name+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	public Bindable getBindable(String name){
		if(this.var_map.containsKey(name))
			return this.var_map.get(name);
		else{
			try {
				throw this.getArgException("name", "getBindable", 
						"There is no bindable with name \""+name+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public Boolean putFormulation(String name,LogicFormulation form){
		if(name==null||form==null){
			try {
				throw this.getArgException("name|form", "putFormulation", 
						"try to call putFormulation("+name+","+form+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		this.form_map.put(name, form);
		return true;
		
	}
	public Boolean putBindable(String name,Bindable var){
		if(name==null||var==null){
			try {
				throw this.getArgException("name|form", "putBindable", 
						"try to call putFormulation("+name+","+var+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		this.var_map.put(name, var);
		return true;
	}

	protected LogicFormulation removeFormulation(String name){
		if(this.form_map.containsKey(name))
			return this.form_map.remove(name);
		else{
			try {
				throw this.getArgException("name", "removeFormulation", 
						"try to remove undefined formulation \""+name+"\" in form_map");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	protected Bindable removeBindable(String name){
		if(this.var_map.containsKey(name))
			return this.var_map.remove(name);
		else{
			try {
				throw this.getArgException("name", "removeBindable", 
						"try to remove undefined bindable \""+name+"\" in var_map");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void clear(){
		this.form_map.clear();
		this.var_map.clear();
	}
	/*
	 *	Creator 
	 *	==========================================================================================
	 *		1) PropositionVariable
	 *			a. createPropositionVariable(): 
	 *				note: create a proposition variable with random ID (as its ID and name)
	 *				exceptions: 
	 *					-ex1: failed when ID space is used out
	 *				othr: the new proposition with its random ID put into var_map, ID as its name
	 *				 and returned
	 *			b. createPropositionVariable(name):
	 *				note: create a proposition variable with specified name (as its ID and name)
	 *				exceptions:
	 *					-ex1: null name --> invalid ID and name
	 *					-ex2: used name --> invalid ID and name (used in var_map)
	 *				othr: the new proposition variable is added into var_map, name as its name,
	 *				 and returned.
	 *	==========================================================================================
	 *		2) Predicate Formulation
	 *			a. createPredicate(name, vars)
	 *				note: create a predicate formulation, put it into var_map, set its name as name
	 *				manage it by ID (name) in the var_map, and set its variables as vars.
	 *				exceptions:
	 *					-ex1: null name --> invalid ID+name
	 *					-ex2: used name --> invalid ID+name
	 *					-ex3: null vars --> invalid variables List 
	 *			b. createPredicate(name)
	 *				note: createPredicate(name,[])
	 *			c. createPredicate(vars)
	 *				note: createPredicate(random_id,vars)
	 *			d. createPredicate()
	 *				note: createPredicate(random_id,[])
	 *	==========================================================================================
	 *		3) Variable
	 *			a. createVariable(name)
	 *				note: new var; var.name = name; var_map.put(name,var); return var.
	 *					-ex1: null name --> invalid variable name
	 *					-ex2: used name --> invalid variable name
	 *			b. createVariable()
	 *				note: createVariable(random_id)
	 *				exceptions:
	 *					-ex1: ID space is used out
	 *	==========================================================================================
	 *		4) DiscourseDomain
	 *			a. createDiscourseDomain(name)
	 *				note: new domain; domain.name = name; new var; domain.iter = var; 
	 *					  var.name = domain.name + "_iter"; var_map.put(name,domain); 
	 *					  return domain.
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: used name
	 *			b. createDiscourseDomain()
	 *				note: createDiscourseDomain(random_id);
	 *				exception: ID space is used out.
	 * 	==========================================================================================
	 *		5) LogicExpression(Conjunction) [Disjunction]
	 *			a. createConjunction(name,children)
	 *				note: new expr; expr.name = name; expr.op = new and; and.children = children; form_map.put(name,expr); return expr;
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: used name
	 *					-ex3: null children
	 *			b. createConjunction(name)
	 *				note: createConjunction(name,[])
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: used name
	 *			c. createConjunction(children)
	 *				note: createConjunction(random_id,children);
	 *				exceptions:
	 *					-ex1: id space used out
	 *					-ex2: null children
	 *			d. createConjunction()
	 *				note: createConjunction(random_id,children);
	 *				exceptions:
	 *					-ex1: id space used out
	 *	==========================================================================================
	 *		6) LogicExpression(Negation)
	 *			a. createNegation(name,child)
	 *				note: new expr; expr.name=name; expr.op=new not; not.child=child; form_map.put(name,child); return expr;
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: used name
	 *					{permit null child!!!}
	 *			b. createNegation(name)
	 *				note: createNegation(name,null)
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: used name
	 *			c. createNegation(child)
	 *				note: createNegation(random_id,child)
	 *				exceptions:
	 *					-ex1: id space used out
	 *			d. createNegation()	
	 *				note: createNegation(random_id,null)
	 *				exceptions:
	 *					-ex1: id space used out
	 *	==========================================================================================
	 *		7) LogicExpression(Implication/Equivalence)
	 *			a. createImplication(name,premise,conclusion)
	 *				note: new expr; expr.name=name; expr.op=new impl; impl.premise=premise; impl.conclusion=conclusion; form_map.put(name,expr); return expr;
	 *				exceptions:
	 *					--ex1: null name
	 *					--ex2: used name
	 *					(permit null premise+conclusion)
	 *			b. createImplication(name)
	 *				note: createImplication(name,null,null);
	 *				exceptions:	
	 *					-ex1: null name
	 *					-ex2: used name
	 *			c. createImplication(premise,conclusion)
	 *				note: createImplication(random_id,premise,conclusion)
	 *				exceptions:
	 *					-ex1: id space used out
	 *			d. createImplication()
	 *				note: createImplication(random_id,null.null)
	 *				exceptions:
	 *					-ex1: id space used out
	 *	==========================================================================================
	 *		8) Quantification(Universal/Equivalence)
	 *			a. createUniversal(name,domain,scope)
	 *				note: new u; u.name = name; u.domain = domain; u.scope = scope; form_map.put(name,u); return u;
	 *				exceptions
	 *					-ex1: null name	
	 *					-ex2: used name
	 *			b. createUniversal(name)
	 *				note: createUniversal(name,null,null)
	 *				exceptions:
	 *					-ex1: null name
	 *					-ex2: used name
	 *
	 *
	 */
	public PropositionVariable createPropositionVariable(){
		PropositionVariable var = LogicFormulationFactory.createPropositionVariable();
		try {
			String name = this.getNextID(var, this.var_map);
			var.setName(name);
			this.var_map.put(name, var);
			
			return var;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public PropositionVariable createPropositionVariable(String name){
		if(name==null||this.var_map.containsKey(name)){
			try {
				throw this.getArgException("name", "createPropositionVariable(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		PropositionVariable var = LogicFormulationFactory.createPropositionVariable();
		
		var.setName(name);
		this.var_map.put(name, var);
		
		return var;
	}
	
	public PredicateFormulation createPredicate(){
		PredicateFormulation form = LogicFormulationFactory.createPredicateFormulation();
		
		try {
			String name = this.getNextID(form, this.var_map);
			
			form.setName(name);
			
			this.var_map.put(name, form);
			return form;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public PredicateFormulation createPredicate(String name){
		if(name==null||this.var_map.containsKey(name)){
			try {
				throw this.getArgException("name", "createPredicate(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		PredicateFormulation form = LogicFormulationFactory.createPredicateFormulation();
		
		form.setName(name);
		this.var_map.put(name, form);
		
		return form;
	}
	public PredicateFormulation createPredicate(String name,List<Variable> vars){
		PredicateFormulation form = this.createPredicate(name);
		if(vars!=null){
			for(int i=0;i<vars.size();i++){
				form.getVariables().add(vars.get(i));
			}
			return form;
		}
		
		else{
			try {
				throw this.getArgException("vars", "createPredicate(name,vars)", 
						"null vars is not permited to create a predicate");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	public PredicateFormulation createPredicate(List<Variable> vars){
		PredicateFormulation form = this.createPredicate();
		if(vars!=null){
			for(int i=0;i<vars.size();i++){
				form.getVariables().add(vars.get(i));
			}
			return form;
		}
		else{
			try {
				throw this.getArgException("vars", "createPredicate(vars)",
						"null variables is unpermitted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	
	public Variable createVariable(){
		Variable var = LogicFormulationFactory.createVariable();
		try {
			String name = this.getNextID(var, this.var_map);
			
			var.setName(name);
			this.var_map.put(name, var);
			
			return var;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Variable createVariable(String name){
		if(name==null||this.var_map.containsKey(name)){
			try {
				throw this.getArgException("name", "createVariable(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Variable var = LogicFormulationFactory.createVariable();
		var.setName(name);
		this.var_map.put(name, var);
		return var;
	}
	
	
	public DiscourseDomain createDiscourseDomain(){
		DiscourseDomain domain = LogicFormulationFactory.createDiscourseDomain();
		try {
			String name = this.getNextID(domain, this.var_map);
			
			domain.setName(name);
			
			/*
			 * Initial Internal Iterator: Using external names cannot find this iterator variable
			 */
			Variable var = LogicFormulationFactory.createVariable();
			var.setName(name+"_iter");
			domain.setIter(var);
			
			this.var_map.put(name, domain);
			
			return domain;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public DiscourseDomain createDiscourseDomain(String name){
		if(this.var_map.containsKey(name)||name==null){
			try {
				throw this.getArgException("name", "createDiscourseDomain(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		DiscourseDomain domain = LogicFormulationFactory.createDiscourseDomain();
		domain.setName(name);
		
		/*
		 *	Iterator Variable 
		 */
		Variable var = LogicFormulationFactory.createVariable();
		var.setName(name+"_iter");
		domain.setIter(var);
		
		this.var_map.put(name, domain);
		return domain;
	}
	
	
	
	LogicExpression createExpression(){
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		
		try {
			String name = this.getNextID(expr, form_map);
			
			expr.setName(name);
			this.form_map.put(name, expr);
			
			return expr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	LogicExpression createExpression(String name){
		if(name==null||this.form_map.containsKey(name)){
			try {
				throw this.getArgException("name", "createExpression(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		LogicExpression expr = LogicFormulationFactory.createLogicExpression();
		expr.setName(name);
		this.form_map.put(name, expr);
		
		return expr;
	}
	
	
	
	public LogicExpression createConjunction(){
		LogicExpression expr = this.createExpression();
		expr.setOperator(LogicFormulationFactory.createConjunction());
		return expr;
	}
	public LogicExpression createConjunction(String name){
		LogicExpression expr = this.createExpression(name);
		expr.setOperator(LogicFormulationFactory.createConjunction());
		return expr;
	}
	public LogicExpression createConjunction(List<LogicFormulation> children){
		if(children==null){
			try {
				throw this.getArgException("children", "createConjunction(children)", "Null children");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LogicExpression expr = this.createConjunction();
		if(children!=null){
			Conjunction op = (Conjunction) expr.getOperator();
			for(int i=0;i<children.size();i++){
				op.getFormulations().add(children.get(i));
			}
		}
		return expr;
	}
	public LogicExpression createConjunction(String name,List<LogicFormulation> children){
		if(children==null){
			try {
				throw this.getArgException("children", "createConjunction(name,children)", "Null children");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LogicExpression expr = this.createConjunction(name);
		
		if(children!=null){
			Conjunction op = (Conjunction) expr.getOperator();
			for(int i=0;i<children.size();i++){
				op.getFormulations().add(children.get(i));
			}
		}
		return expr;
	}
	
	public LogicExpression createDisjunction(){
		LogicExpression expr = this.createExpression();
		expr.setOperator(LogicFormulationFactory.createDisjunction());
		return expr;
	}
	public LogicExpression createDisjunction(String name){
		LogicExpression expr = this.createExpression(name);
		expr.setOperator(LogicFormulationFactory.createDisjunction());
		return expr;
	}
	public LogicExpression createDisjunction(List<LogicFormulation> children){
		if(children==null){
			try {
				throw this.getArgException("children", "createDisjunction(children)", "Null children");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LogicExpression expr = this.createDisjunction();
		if(children!=null){
			Disjunction op = (Disjunction) expr.getOperator();
			for(int i=0;i<children.size();i++)
				op.getFormulations().add(children.get(i));
		}
		return expr;
	}
	public LogicExpression createDisjuntion(String name,List<LogicFormulation> children){
		if(children==null){
			try {
				throw this.getArgException("children", "createDisjunction(name,children)", "Null children");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LogicExpression expr = this.createDisjunction(name);
		if(children!=null){
			Disjunction op = (Disjunction) expr.getOperator();
			for(int i=0;i<children.size();i++)
				op.getFormulations().add(children.get(i));
		}
		return expr;
	}
	
	
	public LogicExpression createNegation(){
		LogicExpression expr = this.createExpression();
		expr.setOperator(LogicFormulationFactory.createNegation());
		return expr;
	}
	public LogicExpression createNegation(String name){
		LogicExpression expr = this.createExpression(name);
		expr.setOperator(LogicFormulationFactory.createNegation());
		return expr;
	}
	public LogicExpression createNegation(LogicFormulation child){
		/*if(child==null){
			try {
				throw this.getArgException("child", "createNegation(child)", "Null child");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}*/
		
		LogicExpression expr = this.createNegation();
		Negation op = (Negation) expr.getOperator();
		op.setFormulation(child);
		return expr;
	}
	public LogicExpression createNegation(String name,LogicFormulation child){
		/*if(child==null){
			try {
				throw this.getArgException("child", "createNegation(name,child)", "Null child");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}*/
		
		LogicExpression expr = this.createNegation(name);
		Negation op = (Negation) expr.getOperator();
		op.setFormulation(child);
		return expr;
	}
	
	
	public LogicExpression createImplication(){
		LogicExpression expr = this.createExpression();
		expr.setOperator(LogicFormulationFactory.createImplication());
		return expr;
	}
	public LogicExpression createImplication(String name){
		LogicExpression expr = this.createExpression(name);
		expr.setOperator(LogicFormulationFactory.createImplication());
		return expr;
	}
	public LogicExpression createImplication(LogicFormulation premise,LogicFormulation conclusion){
		LogicExpression expr = this.createImplication();
		
		Implication op =(Implication) expr.getOperator();
		op.setPremise(premise);
		op.setConclusion(conclusion);
		
		return expr;
	}
	public LogicExpression createImplication(String name, 
			LogicFormulation premise, LogicFormulation conclusion){
		LogicExpression expr = this.createImplication(name);
		
		Implication op =(Implication) expr.getOperator();
		op.setPremise(premise);
		op.setConclusion(conclusion);
		
		return expr;
	}
	
	
	public LogicExpression createEquivalence(){
		LogicExpression expr = this.createExpression();
		expr.setOperator(LogicFormulationFactory.createEquivalence());
		return expr;
	}
	public LogicExpression createEquivalence(String name){
		LogicExpression expr = this.createExpression(name);
		expr.setOperator(LogicFormulationFactory.createEquivalence());
		return expr;
	}
	public LogicExpression createEquivalence(LogicFormulation f1,LogicFormulation f2){
		LogicExpression expr = this.createEquivalence();
		
		Equivalence op = (Equivalence) expr.getOperator();
		op.setFormulation1(f1);
		op.setFormulation2(f2);
		
		return expr;
	}
	public LogicExpression createEquivalence(String name,LogicFormulation f1,LogicFormulation f2){
		LogicExpression expr = this.createEquivalence(name);
		
		Equivalence op = (Equivalence) expr.getOperator();
		op.setFormulation1(f1);
		op.setFormulation2(f2);
		
		return expr;
	}

	
	public Universal createUniversal(){
		Universal u = LogicFormulationFactory.createUniversal();
		
		try {
			String name = this.getNextID(u, form_map);
			
			u.setName(name);
			this.form_map.put(name, u);

			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public Universal createUniversal(String name){
		if(this.form_map.containsKey(name)||name==null){
			try {
				throw this.getArgException("name", "createUniversal(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		Universal u = LogicFormulationFactory.createUniversal();
		
		u.setName(name);
		this.form_map.put(name, u);
		
		return u;
	}
	public Universal createUniversal(String name,DiscourseDomain domain,LogicFormulation scope){
		Universal u = this.createUniversal(name);
		u.setDomain(domain);u.setScope_formulation(scope);
		return u;
	}
	public Universal createUniversal(DiscourseDomain domain,LogicFormulation scope){
		Universal u = this.createUniversal();
		u.setDomain(domain);u.setScope_formulation(scope);
		return u;
	}
	
	
	public Existential createExistential(){
		Existential e = LogicFormulationFactory.createExistential();
		
		try {
			String name = this.getNextID(e, form_map);
			e.setName(name);
			this.form_map.put(name, e);
			return e;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	public Existential createExistential(String name){
		if(name==null||this.form_map.containsKey(name)){
			try {
				throw this.getArgException("name", "createExistential(name)", 
						"Conflict Name \""+name+"\"");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		Existential e = LogicFormulationFactory.createExistential();
		e.setName(name);
		this.form_map.put(name, e);
		return e;
	}
	public Existential createExistential(DiscourseDomain domain,LogicFormulation scope){
		Existential e = this.createExistential();
		e.setDomain(domain);e.setScope_formulation(scope);
		return e;
	}
	public Existential createExistential(String name,DiscourseDomain domain,LogicFormulation scope){
		Existential e = this.createExistential(name);
		e.setDomain(domain);e.setScope_formulation(scope);
		return e;
	}

}
