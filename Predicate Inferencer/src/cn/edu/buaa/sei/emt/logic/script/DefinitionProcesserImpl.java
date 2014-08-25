package cn.edu.buaa.sei.emt.logic.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.sei.emt.logic.creator.LogicCreator;
import cn.edu.buaa.sei.emt.logic.creator.LogicModifier;
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
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class DefinitionProcesserImpl implements DefinitionProcesser{
	String name;
	List<DefinitionUnit> units = new ArrayList<DefinitionUnit>();
	LogicCreator creator = new LogicCreator("LogicSyntaxProcesser.creator");
	
	public DefinitionProcesserImpl(String name){
		this.name=name;
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Definition Processer "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}

	Object generateNewObject(String type,String name) throws Exception{
		if(name==null||type==null){
			throw this.getArgException("type|name", 
					"generateNewObject(type,name)", "null arguments are invalid.");
		}
		
		if(type.equals(DefinitionUnit.AND)){
			return this.creator.createConjunction(name);
		}
		else if(type.equals(DefinitionUnit.OR)){
			return this.creator.createDisjunction(name);
		}
		else if(type.equals(DefinitionUnit.NOT)){
			return this.creator.createNegation(name);
		}
		else if(type.equals(DefinitionUnit.IMPL)){
			return this.creator.createImplication(name);
		}
		else if(type.equals(DefinitionUnit.EQ)){
			return this.creator.createEquivalence(name);
		}
		else if(type.equals(DefinitionUnit.ALL)){
			return this.creator.createUniversal(name);
		}
		else if(type.equals(DefinitionUnit.ANY)){
			return this.creator.createExistential(name);
		}
		else if(type.equals(DefinitionUnit.VAR)){
			return this.creator.createVariable(name);
		}
		else if(type.equals(DefinitionUnit.PROP)){
			return this.creator.createPropositionVariable(name);
		}
		else if(type.equals(DefinitionUnit.PRED)){
			return this.creator.createPredicate(name);
		}
		else if(type.equals(DefinitionUnit.DOMAIN)){
			return this.creator.createDiscourseDomain(name);
		}
		
		return null;
	}
	
	void interprete(DefinitionUnit unit,Object value,Map<String,Object> ref_map) throws Exception{
		// Null check
		if(unit==null||value==null||ref_map==null){
			throw this.getArgException("unit|value|ref_map", "interprete(unit,value,ref_map)", 
					"Null arguments cannot be interpreted.");
		}
		
		if(value instanceof PropositionVariable){
			this.interpreteProposition(unit, value, ref_map);
			return;
		}
		else if(value instanceof Variable){
			this.interpreteVariable(unit, value, ref_map);
			return;
		}
		else if(value instanceof DiscourseDomain){
			return;
		}
		else if(value instanceof PredicateFormulation){
			this.interpretePredicate(unit, value, ref_map);
			return;
		}
		else if(value instanceof LogicExpression){
			this.interpreteLogicExpression(unit, value, ref_map);
			return;
		}
		else if(value instanceof Quantification){
			this.interpreteQuantification(unit, value, ref_map);
			return;
		}
		
		throw this.getArgException("value", "interprete(unit,value,ref_map)", "invalid type of value");
	}
	void interpreteProposition(DefinitionUnit unit,Object value,Map<String,Object> ref_map) throws Exception{
		if(unit==null||value==null||ref_map==null){
			throw this.getArgException("unit|value|ref_map", "interpreteProposition(unit,value,ref_map)", 
					"Null arguments cannot be interpreted.");
		}
		return;
	}
	void interpreteVariable(DefinitionUnit unit,Object value,Map<String,Object> ref_map) throws Exception{
		if(unit==null||value==null||ref_map==null){
			throw this.getArgException("unit|value|ref_map", "interpreteVariable(unit,value,ref_map)", 
					"Null arguments cannot be interpreted.");
		}
		return;
	}
	void interpretePredicate(DefinitionUnit unit,Object value,Map<String,Object> ref_map) throws Exception{
		if(unit==null||value==null||ref_map==null){
			throw this.getArgException("unit|value|ref_map", "interpretePredicate(unit,value,ref_map)", 
					"Null arguments cannot be interpreted.");
		}
		
		String[] args = unit.getArgs();
		if(args==null||args.length<1){
			throw this.getArgException("unit.args", 
					"interpretePredicate(unit,value,ref_map)", "unit.args is invalid");
		}
		
		for(int i=0;i<args.length;i++){
			String arg_name = args[i];
			Object arg_var = ref_map.get(arg_name);
			if(arg_var==null){
				throw this.getArgException(unit.getVar()+"."+arg_name, 
						"interpretePredicate(unit,value.ref_map)", arg_name 
						+ "is not defined");
			}
			if(!(arg_var instanceof Variable)){
				throw this.getArgException(unit.getVar()+"."+arg_name, 
						"interpretePredicate(unit,value.ref_map)", arg_name 
						+ "is not a variable: error type \""+arg_var.getClass().getName()+"\"");
			}
			LogicModifier.appendPredicate((PredicateFormulation)value, (Variable)arg_var);
		}
		return;
	}
	void interpreteLogicExpression(DefinitionUnit unit,Object value,Map<String,Object> ref_map) throws Exception{
		if(unit==null||value==null||ref_map==null){
			throw this.getArgException("unit|value|ref_map", "interpreteLogicExpression(unit,value,ref_map)", 
					"Null arguments cannot be interpreted.");
		}
		
		LogicExpression expr = (LogicExpression) value;
		LogicOperator op = expr.getOperator();
		
		String[] args = unit.getArgs();
		if(args==null)
			throw this.getArgException("unit.args", "interpreteLogicExpression(unit,value,ref_map)",
					"units.args is null");
		
		if(op instanceof Conjunction){
			if(args.length<2)
				throw this.getArgException("unit.args", "interpreteLogicExpression(unit,value,ref_map)",
						"Conjunction requires at least two arguments.");
			for(int i=0;i<args.length;i++){
				Object ref = ref_map.get(args[i]);
				if(ref==null)
					throw this.getArgException("unit.arg["+i+"]", "interpreteLogicExpression(unit,value,ref_map)",
							args[i]+" has not been defined.");
				if(!(ref instanceof LogicFormulation))
					throw this.getArgException("unit.arg["+i+"]", "interpreteLogicExpression(unit,value,ref_map)",
							args[i]+" is not LogicFormulation");
				else{
					LogicModifier.appendConjunction((Conjunction)op, (LogicFormulation)ref);
				}
			}
		}
		else if(op instanceof Disjunction){
			if(args.length<2)
				throw this.getArgException("unit.args", "interpreteLogicExpression(unit,value,ref_map)",
						"Disjunction requires at least two arguments.");
			for(int i=0;i<args.length;i++){
				Object ref = ref_map.get(args[i]);
				if(ref==null)
					throw this.getArgException("unit.arg["+i+"]", "interpreteLogicExpression(unit,value,ref_map)",
							args[i]+" has not been defined.");
				if(!(ref instanceof LogicFormulation))
					throw this.getArgException("unit.arg["+i+"]", "interpreteLogicExpression(unit,value,ref_map)",
							args[i]+" is not LogicFormulation");
				else{
					LogicModifier.appendDisjunction((Disjunction)op, (LogicFormulation)ref);
				}
			}
		}
		else if(op instanceof Negation){
			if(args.length!=1)
				throw this.getArgException("unit.args", 
						"interpreteLogicExpression(unit,value,ref_map)", "Negation only need one argument");
			
			Object ref = ref_map.get(args[0]);
			if(ref instanceof LogicFormulation)
				LogicModifier.modifyNegation((Negation)op, (LogicFormulation)ref);
			else{
				throw this.getArgException("unit.args[0]", "interpreteLogicExpression(unit,value,ref_map)",
						args[0]+" is not LogicFormulation");
			}
		}
		else if(op instanceof Implication){
			if(args.length!=2)
				throw this.getArgException("unit.args", 
						"interpreteLogicExpression(unit,value,ref_map)", "Implication need two argument");
			
			Object premise = ref_map.get(args[0]);
			Object conclusion = ref_map.get(args[1]);
			
			if(premise==null||!(premise instanceof LogicFormulation)){
				throw this.getArgException("unit.args[0]", "interpreteLogicExpression(unit,value,ref_map)", 
						args[0]+" is not LogicFormulation");
			}
			if(conclusion==null||!(conclusion instanceof LogicFormulation)){
				throw this.getArgException("unit.args[1]", "interpreteLogicExpression(unit,value,ref_map)", 
						args[1]+" is not LogicFormulation");
			}
			
			LogicModifier.modifyImplication((Implication)op, 
					(LogicFormulation)premise, (LogicFormulation)conclusion);
			
		}
		else if(op instanceof Equivalence){
			if(args.length!=2)
				throw this.getArgException("unit.args", 
						"interpreteLogicExpression(unit,value,ref_map)", "Equivalence need two argument");
			
			Object f1 = ref_map.get(args[0]);
			Object f2 = ref_map.get(args[1]);
			
			if(f1==null||!(f1 instanceof LogicFormulation)){
				throw this.getArgException("unit.args[0]", "interpreteLogicExpression(unit,value,ref_map)", 
						args[0]+" is not LogicFormulation");
			}
			if(f2==null||!(f2 instanceof LogicFormulation)){
				throw this.getArgException("unit.args[1]", "interpreteLogicExpression(unit,value,ref_map)", 
						args[1]+" is not LogicFormulation");
			}
			
			LogicModifier.modifyEquivalence((Equivalence)op, 
					(LogicFormulation)f1, (LogicFormulation)f2);
		}
		
		
	}
	void interpreteQuantification(DefinitionUnit unit,Object value,Map<String,Object> ref_map) throws Exception{
		if(unit==null||value==null||ref_map==null){
			throw this.getArgException("unit|value|ref_map", "interpreteQuantification(unit,value,ref_map)", 
					"Null arguments cannot be interpreted.");
		}
		
		String[] args = unit.getArgs();
		if(args==null||args.length!=2)
			throw this.getArgException("unit.args", "interpreteQuantification(unit,value,ref_map)", 
					"Quantification need two arguments.");
		
		String domain_name = args[0];
		String scope_name = args[1];
		
		Object domain = ref_map.get(domain_name);
		Object scope = ref_map.get(scope_name);
		
		if(domain==null)
			throw this.getArgException("unit.args[0]", "interpreteQuantification(unit,value,ref_map)",
					domain_name+" is not defined");
		if(scope==null)
			throw this.getArgException("unit.args[1]", "interpreteQuantification(unit,value,ref_map)",
					scope_name+" is not defined");
		if(!(domain instanceof DiscourseDomain))
			throw this.getArgException("domain_name", "interpreteQuantification(unit,value,ref_map)", 
					domain_name+" is not a DiscourseDomain");
		if(!(scope instanceof LogicFormulation))
			throw this.getArgException("scope_name", "interpreteQuantification(unit,value,ref_map)", 
					scope_name+" is not a LogicFormulation");
		
		LogicModifier.modifyQuantification((Quantification)value, (DiscourseDomain)domain, 
				(LogicFormulation)scope);
	}
	
	/*
	 *	Core Functions
	 * 
	 */
	@Override
	public void appendUnit(DefinitionUnit unit) {
		// TODO Auto-generated method stub
		if(unit==null){
			try {
				throw this.getArgException("unit", "appendUnit(unit)", "null unit is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.units.add(unit);
	}

	@Override
	public void appendUnitList(List<DefinitionUnit> units) {
		// TODO Auto-generated method stub
		if(units==null){
			try {
				throw this.getArgException("units","appendUnitList(units)", "null units is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		for(int i=0;i<units.size();i++){
			if(units.get(i)==null)continue;
			else this.units.add(units.get(i));
		}
	}

	@Override
	public DefinitionUnit getUnit(int i) {
		// TODO Auto-generated method stub
		if(i<0||i>=this.units.size()){
			try {
				throw this.getArgException("i", "getUnit(i)", i+" is out of range: size = "+this.units.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.units.get(i);
	}

	@Override
	public Boolean removeUnit(int i) {
		if(i<0||i>=this.units.size()){
			try {
				throw this.getArgException("i", "removeUnit(i)", i+" is out of range: size = "+this.units.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		this.units.remove(i);
		return true;
	}

	@Override
	public void clearUnitList() {
		// TODO Auto-generated method stub
		this.units.clear();
	}

	@Override
	public int getUnitListSize() {
		// TODO Auto-generated method stub
		return this.units.size();
	}

	@Override
	public LogicCreator compile() throws Exception {
		// TODO Auto-generated method stub
		this.creator.clear();
		Map<String,Object> var_map = this.initialization();
		this.linkArguments(var_map);
		return this.creator;
	}
	
	Map<String,Object> initialization() throws Exception{
		Map<String,Object> var_map = new HashMap<String,Object>();
		for(int i=0;i<this.units.size();i++){
			// getting unit
			DefinitionUnit unit = this.units.get(i);
			
			// check null/var name
			if(unit==null)continue;
			if(var_map.containsKey(unit.getVar())){
				throw this.getArgException("units["+i+"]", "initialization()", 
						"Name Conflicts: "+unit.getVar());
			}
			
			// generate formulation/variable object.
			Object value = this.generateNewObject(unit.getType(), unit.getVar());
			if(value==null){
				throw this.getArgException("creator", "initialization()", 
						"generate new instance failed!");
			}
			// Discourse Domain's iterator should be processed and put into the map.
			if(value instanceof DiscourseDomain){
				String iter_name = ((DiscourseDomain) value).getName()+DefinitionUnit.ITER;
				if(var_map.containsKey(iter_name)){
					throw this.getArgException("units["+i+"].iter", "initialization()", 
							"Name Conflicts: "+iter_name);
				}
				var_map.put(iter_name, ((DiscourseDomain) value).getIter());
			}
			
			var_map.put(unit.getVar(), value);
		}
		return var_map;
	}
	void linkArguments(Map<String,Object> var_map) throws Exception{
		if(var_map==null){
			throw this.getArgException("var_map", 
					"linkArguments(var_map)", "null var_map is invalid");
		}
		
		for(int i=0;i<this.units.size();i++){
			DefinitionUnit unit = this.units.get(i);
			// null|map incomplete.
			if(unit==null){
				/*throw this.getArgException("units["+i+"]","linkArguments(var_map)", 
						"units["+i+"] is null and cannot be linked.");*/
				continue;
			}
			String name = unit.getVar();
			if(!var_map.containsKey(name)){
				throw this.getArgException("var_map", "linkArgument(var_map)", 
						"var_map is incomplete: lacking \""+name+"\"");
			}
			
			Object value = var_map.get(name);
			this.interprete(unit, value, var_map);
		}
	}
	
	
}
