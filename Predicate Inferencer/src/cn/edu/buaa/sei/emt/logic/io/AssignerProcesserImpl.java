package cn.edu.buaa.sei.emt.logic.io;

import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.creator.LogicAccessor;
import cn.edu.buaa.sei.emt.logic.creator.LogicAssigner;
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
import cn.edu.buaa.sei.lmf.ManagedObject;

public class AssignerProcesserImpl implements AssignerProcesser{
	Map<String,Object> space;
	Map<String,String> assign_map;
	ValueInterpreter interpreter;
	String name;
	
	public AssignerProcesserImpl(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Assigner Processer "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	Object getVariable(String name){
		if(name==null)return null;
		if(this.space.containsKey(name))return this.space.get(name);
		else{
			int k = name.indexOf("\\.");
			if(k<0)return null;
			Object obj = this.space.get(name.subSequence(0, k));
			if(obj==null||!(obj instanceof LogicFormulation))return null;
			return LogicAccessor.getElementByName(name, (LogicFormulation) obj);
		}
	}
	
	/*
	 *	Setter & Getter 
	 */
	public void setSpace(Map<String,Object> space){this.space=space;}
	public void setAssignMap(Map<String,String> assign_map){this.assign_map=assign_map;}
	public void setValueInterpreter(ValueInterpreter interpreter){this.interpreter=interpreter;}
	public ValueInterpreter getValueInterpreter(){return this.interpreter;}
	public Map<String,String> getAssignMap(){return this.assign_map;}
	public Map<String,Object> getSpace(){return this.space;}

	/*
	 *	Core Functions 
	 */
	@Override
	public Boolean validate() {
		if(this.interpreter==null){
			try {
				throw this.getArgException("this.interpreter", "validate()", 
						"Value Interpreter has not been configurated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(this.space==null){
			try {
				throw this.getArgException("this.space", "validate()", 
						"Space for variables has not been configurated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(this.assign_map==null){
			try {
				throw this.getArgException("this.assign_map", "validate()", 
						"Assigment Map has not been configurated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> names = this.assign_map.keySet();
		
		for(String name:names){
			String value = this.assign_map.get(name);
			if(!validateVariable(name)){
				try {
					throw this.getArgException(name, "validate()", "variable name errors");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			if(!validateValue(value)){
				try {
					throw this.getArgException(name, "validate()", "value of variable interprete errors");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		}
		
		
		return true;
	}
	Boolean validateVariable(String name){
		if(name==null){
			try {
				throw this.getArgException("name", "validateVariable(name)", "null name error");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(this.space.containsKey(name))return true;
		
		int k = name.indexOf("\\.");
		if(k<0){
			try {
				throw this.getArgException(name, "validateVariable(name)", 
						name + "has not been found in space");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		String n1 = name.substring(0, k);
		if(!this.space.containsKey(n1)||!(this.space.get(n1) instanceof LogicFormulation)){
			try {
				throw this.getArgException("name.first", "validateVariable(name)", n1+" is not logic formula");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Object obj = LogicAccessor.getElementByName(name, (LogicFormulation) this.space.get(n1));
		if(obj==null){
			try {
				throw this.getArgException("name", "validateVariable(name)", 
						name + "has not been found in space");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		return true;
	}
	Boolean validateValue(String value){
		if(value==null){
			try {
				throw this.getArgException("value", "validateValue(value)", "null value error");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		try {
			if(!this.interpreter.isValid(value)){
				throw this.getArgException("value", "validateValue(value)", "in-valid value");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public void assign() {
		if(!this.validate()){
			try {
				throw this.getArgException("???", "assign()", "validation failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		Set<String> names = this.assign_map.keySet();
		
		for(String name:names){
			try {
				String value = this.assign_map.get(name);
				Object var = this.getVariable(name);
				Value val = this.interpreter.interprete(value);
				
				if(var == null)
					throw this.getArgException("name", "assign()", name+" was not found in space");
				if(value == null)
					throw this.getArgException("value[name]", "assign()", name+"\'s was generated failed.");
				
				if((var instanceof PropositionVariable)&&(val instanceof BooleanObject))
					LogicAssigner.assignPropositionVariable((PropositionVariable)var, (BooleanObject)val);
				else if((var instanceof Variable)&&(val instanceof LObject))
					LogicAssigner.assignVariable((Variable)var, (LObject)val);
				else if((var instanceof DiscourseDomain)&&(val instanceof LSet)){
					LogicAssigner.assignDiscourseDomain((DiscourseDomain)var, (LSet)val);
				}
				else if((var instanceof PredicateFormulation)&&(val instanceof LRelationSet)){
					LogicAssigner.assignPredicateFormulation((PredicateFormulation)var, (LRelationSet)val);
				}
				else{
					throw this.getArgException(name, "assign()", 
							"Type Assignment Error: "+((ManagedObject)var).type().getSimpleName()+" -- " + ((ManagedObject)val).type().getSimpleName());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
