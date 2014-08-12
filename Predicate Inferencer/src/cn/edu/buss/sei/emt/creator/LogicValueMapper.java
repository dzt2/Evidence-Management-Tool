package cn.edu.buss.sei.emt.creator;

import java.util.Map;
import java.util.Set;

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

public class LogicValueMapper {
	LogicFormulation form;
	Map<String,Value> map;
	
	public LogicValueMapper(LogicFormulation form,Map<String,Value> map){
		this.form = form;
		this.map = map;
	}
	
	/*
	 *	Getter & Setter 
	 */
	public LogicFormulation getFormulation(){return this.form;}
	public void setFormulation(LogicFormulation form){this.form=form;}
	public Map<String,Value> getMap(){return this.map;}
	public void setMap(Map<String,Value> map){this.map=map;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Argument Errors Found!");
		code.append("\nType: Argument Errors: ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Validity Verification: check whether the value mapper could success.
	 */
	Boolean validity(){
		if(form==null||map==null){
			try {
				throw this.getArgException("form|map", "validity()", 
						"null formulation or map is invalid!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> ids = map.keySet();
		for(String id:ids){
			/*
			 *	Null ID is invalid. 
			 */
			if(id==null){
				try {
					throw this.getArgException("map", "validity()", "map cannot contain null key!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			/*
			 *	Null Value is invalid. 
			 */
			Value value = this.map.get(id);
			if(value==null){
				try {
					throw this.getArgException("map", "validate()", "Null Value in map is unacceptable.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			/*
			 *	Access Faults could be verified. 
			 */
			ManagedObject elm = (ManagedObject) LogicAccessor.getElementByName(id, form);
			
			/*
			 *	Invalid Path is prevented. 
			 */
			if(elm==null){
				try {
					throw this.getArgException("map", "validity()", 
							"Invalid Path defined in Map: "+id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			/*
			 *	Unassigned Formulation Element is validited. 
			 */
			if(elm instanceof PropositionVariable){
				if(!(value instanceof BooleanObject)){
					try {
						throw this.getArgException("form-map", "validate()", 
								"Wrong Assigned Pair: "+elm.type().getSimpleName()+" := "+value.type().getSimpleName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
				
			}
			else if(elm instanceof Variable){
				if(!(value instanceof LObject)){
					try {
						throw this.getArgException("form-map", "validate()", 
								"Wrong Assigned Pair: "+elm.type().getSimpleName()+" := "+value.type().getSimpleName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
				
			}
			else if(elm instanceof DiscourseDomain){
				if(!(value instanceof LSet)){
					try {
						throw this.getArgException("form-map", "validate()", 
								"Wrong Assigned Pair: "+elm.type().getSimpleName()+" := "+value.type().getSimpleName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
			}
			else if(elm instanceof PredicateFormulation){
				if(value instanceof LRelationSet){
					continue;
				}
				else{
					try {
						throw this.getArgException("form-map", "validate()", 
								"Wrong Assigned Pair: "+elm.type().getSimpleName()+" := "+value.type().getSimpleName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
			}
			else{
				try {
					throw this.getArgException("formulation elm", "validate()", 
							id + " --> "+elm.type().getFullName()+": not a valid assigned object.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
		}
		
		return true;
	}
	
	public Boolean assign(){
		if(!this.validity()){
			try {
				throw this.getArgException("form-map", "assign", "Validation Failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		Set<String> ids = this.map.keySet();
		for(String id:ids){
			Value value = this.map.get(id);
			if(value==null)continue;
			Object elm = LogicAccessor.getElementByName(id, form);
			if(elm==null)continue;
			
			if(elm instanceof PropositionVariable){
				LogicAssigner.assignPropositionVariable((PropositionVariable)elm, 
						(BooleanObject)value);
			}
			else if(elm instanceof Variable){
				LogicAssigner.assignVariable((Variable)elm, (LObject)value);
			}
			else if(elm instanceof DiscourseDomain){
				LogicAssigner.assignDiscourseDomain((DiscourseDomain)elm, (LSet)value);
			}
			else if(elm instanceof PredicateFormulation){
				if(value instanceof LRelationSet){
					LogicAssigner.assignPredicateFormulation((PredicateFormulation)elm,
							(LRelationSet)value);
				}
			}
		}
		
		return true;
	}
}
