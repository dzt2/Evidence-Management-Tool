package cn.edu.buaa.sei.emt.logic.script;

import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.creator.LogicAccessor;
import cn.edu.buaa.sei.emt.logic.creator.LogicAssigner;
import cn.edu.buaa.sei.emt.logic.creator.LogicCreator;
import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;

public class ValueMapper {
	private LogicCreator creator;
	private Map<String,Value> map;
	
	public ValueMapper(LogicCreator creator,Map<String,Value> map){
		this.creator=creator;this.map=map;
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Value Mapper reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	public LogicCreator getCreator() {
		return creator;
	}
	public void setCreator(LogicCreator creator) {
		this.creator = creator;
	}
	public Map<String,Value> getMap() {
		return map;
	}
	public void setMap(Map<String,Value> map) {
		this.map = map;
	}

	/*
	 *	Core Functions 
	 */
	public void assign() throws Exception{
		if(this.creator==null||this.map==null){
			throw this.getArgException("creator|map", "assign()", "Unready");
		}
		
		Set<String> names = this.map.keySet();
		Set<String> form_names = this.creator.getFormulationNames();
		Set<String> var_names = this.creator.getBindableNames();
		
		for(String name:names){
			if(form_names.contains(name)){
				try{throw this.getArgException("map["+name+"]", "assign()", "formulation cannot be assigned");}
				catch(Exception e){System.err.println(e.getMessage());}
				continue;
			}
			else if(var_names.contains(name)){
				Bindable var = this.creator.getBindable(name);
				Value value = map.get(name);
				if(!assign(var,value)){
					try{throw this.getArgException(name, "assign()", "Assignment failed");}
					catch(Exception e){System.err.println(e.getMessage());}
					continue;
				}
			}
			else{
				String[] items = name.split("\\.");
				if(items==null||items.length<2){
					try{throw this.getArgException(name, "assign()", "Invalid name");}
					catch(Exception e){System.err.println(e.getMessage());}
					continue;
				}
				
				String pre = items[0];
				if(!form_names.contains(pre)){
					try{throw this.getArgException(name, "assign()", "Invalid name");}
					catch(Exception e){System.err.println(e.getMessage());}
					continue;
				}
				
				LogicFormulation form = this.creator.getFormulation(pre);
				Object target = LogicAccessor.getElementByName(name, form);
				
				if(target==null){
					try{throw this.getArgException(name, "assign()", "Invalid name");}
					catch(Exception e){System.err.println(e.getMessage());}
					continue;
				}
				if(!(target instanceof Bindable)){
					try{throw this.getArgException(name, "assign()", "Invalid name");}
					catch(Exception e){System.err.println(e.getMessage());}
					continue;
				}
				
				Value value = this.map.get(name);
				if(!assign((Bindable) target,value)){
					try{throw this.getArgException(name, "assign()", "Assignment failed");}
					catch(Exception e){System.err.println(e.getMessage());}
					continue;
				}
			}
		}
	}
	
	Boolean assign(Bindable var,Value value){
		if(var==null){
			try{throw this.getArgException("var", "assign(var,value)", "null variable cannot be assigned");}
			catch(Exception e){System.err.println(e.getMessage());}
			return false;
		}
		if(value==null){
			try{throw this.getArgException("value", "assign()", "null value cannot be assigned");}
			catch(Exception e){System.err.println(e.getMessage());}
			return false;
		}
		
		if((var instanceof PropositionVariable)&&(value instanceof BooleanObject))
			LogicAssigner.assignPropositionVariable((PropositionVariable)var, (BooleanObject)value);
		else if((var instanceof Variable)&&(value instanceof LObject))
			LogicAssigner.assignVariable((Variable)var, (LObject)value);
		else if((var instanceof DiscourseDomain)&&(value instanceof LSet))
			LogicAssigner.assignDiscourseDomain((DiscourseDomain)var, (LSet)value);
		else if((var instanceof PredicateFormulation)&&(value instanceof LRelationSet))
			LogicAssigner.assignPredicateFormulation((PredicateFormulation)var, (LRelationSet)value);
		else{
			try{throw this.getArgException("var-value", 
					"assign()", "Type match failed: "+var.type().getSimpleName()+" := "+value.type().getSimpleName());}
			catch(Exception e){System.err.println(e.getMessage());}
			return false;
		}
		return true;
	}
	
	
	
	
	
}
