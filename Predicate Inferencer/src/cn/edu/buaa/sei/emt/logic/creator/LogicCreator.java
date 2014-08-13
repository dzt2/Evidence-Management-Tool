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
	 */
	static final int MAX_ID_TIMES = 16;
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Argument Errors Found!");
		code.append("\nType: Argument Errors: ");
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
		id.append(obj.type().getFullName()+"["+code+"]");		
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
	 *	Setter & Getter 
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
	
	/*
	 *	Creator 
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
		if(this.var_map.containsKey(name)){
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
		}
		
		return form;
	}
	public PredicateFormulation createPredicate(List<Variable> vars){
		PredicateFormulation form = this.createPredicate();
		if(vars!=null){
			for(int i=0;i<vars.size();i++){
				form.getVariables().add(vars.get(i));
			}
		}
		
		return form;
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
		if(this.form_map.containsKey(name)){
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
		LogicExpression expr = this.createDisjunction();
		if(children!=null){
			Disjunction op = (Disjunction) expr.getOperator();
			for(int i=0;i<children.size();i++)
				op.getFormulations().add(children.get(i));
		}
		return expr;
	}
	public LogicExpression createDisjuntion(String name,List<LogicFormulation> children){
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
		LogicExpression expr = this.createNegation();
		Negation op = (Negation) expr.getOperator();
		op.setFormulation(child);
		return expr;
	}
	public LogicExpression createNegation(String name,LogicFormulation child){
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
