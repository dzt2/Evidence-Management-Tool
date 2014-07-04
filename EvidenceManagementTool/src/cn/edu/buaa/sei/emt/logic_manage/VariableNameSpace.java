package cn.edu.buaa.sei.emt.logic_manage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.EntityElement;
import cn.edu.buaa.sei.emt.logic.EntityIndividual;
import cn.edu.buaa.sei.emt.logic.EntityRelation;
import cn.edu.buaa.sei.emt.logic.EntitySet;
import cn.edu.buaa.sei.emt.logic.EntityValue;
import cn.edu.buaa.sei.emt.logic.IndividualVariable;
import cn.edu.buaa.sei.emt.logic.LogicFactory;
import cn.edu.buaa.sei.emt.logic.RelationVariable;
import cn.edu.buaa.sei.emt.logic.SetVariable;
import cn.edu.buaa.sei.emt.logic.ValueVariable;
import cn.edu.buaa.sei.emt.logic.Variable;

public class VariableNameSpace {
	String name = null;
	Map<String,Variable> var_map = new HashMap<String,Variable>();
	
	public VariableNameSpace(String name){
		this.name=name;
	}
	
	/*
	 *	Variable Management 
	 */
	public void addVariable(Variable var){
		if(var==null||this.var_map.containsKey(var.getName())||var.getName()==null)
			return;
		this.var_map.put(var.getName(), var);
	}
	public Variable removeVariable(String name){
		return this.var_map.remove(name);
	}
	public Variable getVariable(String name){
		return this.var_map.get(name);
	}
	public Set<String> getNames(){
		return this.var_map.keySet();
	}
	
	/*
	 *	Type Checking 
	 */
	public static final int NULL_OBJECT = 23;
	public static final int INDIVIDUAL = 24;
	public static final int SET = 25;
	public static final int RELATION = 26;
	public static final int UNKNOWN = 27;
	public static final int VALUE = 28;
	public int getVariableType(String name){
		if(!this.var_map.containsKey(name))
			return NULL_OBJECT;
		Variable var = this.var_map.get(name);
		if(var instanceof IndividualVariable)return INDIVIDUAL;
		if(var instanceof SetVariable) return SET;
		if(var instanceof RelationVariable) return RELATION;
		if(var instanceof ValueVariable) return VALUE;
		else return UNKNOWN;
	}
	
	public static final int SUCCESS = 0;
	public static final int NAME_EXIST = 1;
	public static final int INVALID_ARG = 2;
	public static final int NAME_UNEXIST = 3;
	public static final int ERR_TYPE = 4;
	public int createVariable(String name,int type){
		if(name==null)return INVALID_ARG;
		if(this.var_map.containsKey(name))return NAME_EXIST;
		
		Variable var = null;
		switch(type){
		case NULL_OBJECT: return INVALID_ARG;
		case INDIVIDUAL: var = LogicFactory.createIndividualVariable();break;
		case SET: var = LogicFactory.createSetVariable(); break;
		case RELATION: var = LogicFactory.createRelationVariable(); break;
		case VALUE: var = LogicFactory.createValueVariable(); break;
		default: return INVALID_ARG;
		}
		
		var.setName(name);
		this.addVariable(var);
		return SUCCESS;
	}
	
	/*
	 *	Value Management 
	 */
	public int setValue(String name,EntityElement value){
		if(name==null||value==null)return INVALID_ARG;
		if(!this.var_map.containsKey(name))return NAME_UNEXIST;
		
		Variable var = this.var_map.get(name);
		
		int type = this.getVariableType(name);
		switch(type){
		case INDIVIDUAL:
			if(!(value instanceof EntityIndividual))return ERR_TYPE;
			IndividualVariable ivar = (IndividualVariable) var;
			ivar.setIndividual((EntityIndividual) value);
			break;
		case SET:
			if(!(value instanceof EntitySet))return ERR_TYPE;
			SetVariable svar = (SetVariable) var;
			svar.setSet((EntitySet) value);
			break;
		case RELATION:
			if(!(value instanceof EntityRelation))return ERR_TYPE;
			RelationVariable rvar = (RelationVariable) var;
			rvar.setRelation((EntityRelation) value);
			break;
		case VALUE:
			if(!(value instanceof EntityValue))return ERR_TYPE;
			ValueVariable vvar = (ValueVariable) var;
			vvar.setValue((EntityValue) value);
			break;
			default: var.setBindTo(null);return ERR_TYPE;
		}
		
		var.setBindTo(value);
		return SUCCESS;
	}

	public EntityElement getValue(String name){
		if(name==null||!this.var_map.containsKey(name))return null;
		return this.var_map.get(name).getBindTo();
	}
	
	public void clear(){this.var_map.clear();}
}
