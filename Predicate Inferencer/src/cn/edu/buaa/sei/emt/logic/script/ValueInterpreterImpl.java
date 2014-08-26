package cn.edu.buaa.sei.emt.logic.script;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.emt.logic.creator.ValueCreator;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public class ValueInterpreterImpl implements ValueInterpreter{
	
	public static final char RELATION_LEFT = '[';
	public static final char RELATION_RIGHT = ']';
	public static final char SET_LEFT = '{';
	public static final char SET_RIGHT = '}';
	public static final char SET_DOT = ';';
	public static final char RELATION_DOT=',';
	public static final String RELATION_NAME = "_relation";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	String name;
	ValueCreator creator = new ValueCreator("Value Interpreter's creator");
	
	public ValueInterpreterImpl(String name){this.name=name;}
	
	/*
	 * Tool Functions
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Value Interpreter "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	public String getName(){return this.name;}
	public void setName(String name){this.name=name;}
	public ValueCreator getCreator(){return this.creator;}

	@Override
	public Boolean isValid(ValueUnit unit) {
		ValueType type = this.getType(unit);
		if(type==null){
			try {
				throw this.getArgException("unit", "isValid(unit)", "Type recognition failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		switch(type){
		case Set:break;
		case RelationSet:break;
		case Relation:break;
		case Object:break;
		default: try {
				throw this.getArgException("type", "isValid(unit)", "Un-interpreted type: "+type);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	@Override
	public Value interprete(ValueUnit unit) {
		if(!this.isValid(unit)){
			try {
				throw this.getArgException("validation", "interprete(unit)", "Interpretation failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		ValueType type = this.getType(unit);
		
		switch(type){
		case Object:return this.interpreteObject(unit);
		case Relation:return this.interpreteRelation(unit);
		case Set:return this.interpreteSet(unit);
		case RelationSet:return this.interpreteRelationSet(unit);
		default: return null;
		}
	}
	@Override
	public ValueType getType(ValueUnit unit) {
		String stmt = unit.getValue();
		
		if(stmt==null||stmt.trim().length()==0)return null;
		
		stmt = stmt.trim();
		
		int s = stmt.indexOf(SET_LEFT);
		int e = stmt.lastIndexOf(SET_RIGHT);
		if(s>=0){
			if(e!=stmt.length()-1){
				try {
					throw this.getArgException("unit.value", "getType(unit)", "Invalid statement: "+stmt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			String name = stmt.substring(0, s);
			if(name!=null&&name.trim().equals(RELATION_NAME))
				return ValueType.RelationSet;
			else return ValueType.Set;
		}
		
		s = stmt.indexOf(RELATION_LEFT);
		e = stmt.lastIndexOf(RELATION_RIGHT);
		
		if(s>=0&&e==stmt.length()-1){return ValueType.Relation;}
		else if(s>=0){
			try {
				throw this.getArgException("unit.value", "getType(unit)", "Invalid statement: "+stmt);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		return ValueType.Object;
	}

	
	
	
	LObject interpreteObject(ValueUnit unit){
		if(unit==null){
			try {
				throw this.getArgException("unit", "interpreteObject(unit)", "Null input");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		String value = unit.getValue();
		return this.interpreteObject(value);
	}
	@SuppressWarnings("static-access")
	LObject interpreteObject(String value){
		if(value==null||value.trim().length()==0)return null;
		value=value.trim();
		
		if(value.equals(TRUE))return this.creator.getTrue();
		if(value.equals(FALSE))return this.creator.getFalse();
		
		if(this.creator.containObject(value))return this.creator.getObject(value);
		else return this.creator.createObject(value.trim());
	}
	LRelation interpreteRelation(ValueUnit unit){
		if(unit==null){
			try {
				throw this.getArgException("unit", "interpreteRelation(unit)", "Null input");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		String value = unit.getValue();
		return this.interpreteRelation(value);
	}
	LRelation interpreteRelation(String value){
		if(value==null||value.trim().length()==0)return null;
		value=value.trim();
		
		int s = value.indexOf(RELATION_LEFT);
		int e = value.lastIndexOf(RELATION_RIGHT);
		
		if(s>=0&&e==value.length()-1){
			String name = value.substring(0,s);
			if(name==null||name.trim().length()==0){
				try {
					throw this.getArgException("value.name", "interpreteRelation(value)", "No name is found in: "+value);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			name = name.trim();
			
			value = value.substring(s+1, e);
			if(value==null)return null;
			
			char[] dots = {RELATION_DOT};
			String[] items = value.split(new String(dots));
			if(items==null)return null;
			
			List<LObject> elements = new ArrayList<LObject>();
			for(int i=0;i<items.length;i++){
				String item = items[i];
				if(item==null)return null;
				
				item = item.trim();
				LObject elm = this.interpreteObject(item);
				
				if(elm==null){
					try {
						throw this.getArgException("elements["+i+"]: "+item, "interpreteRelation(unit)", "object generate failed");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return null;
				}
				
				elements.add(elm);
			}
			return this.creator.createRelation(name, elements);
		}
		else return null;
	}
	LSet interpreteSet(ValueUnit unit){
		if(unit==null){
			try {
				throw this.getArgException("unit", "interpreteSet(unit)", "Null input");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.interpreteSet(unit.getValue());
	}
	@SuppressWarnings("static-access")
	LSet interpreteSet(String value){
		if(value==null||value.trim().length()==0)return null;
		
		value = value.trim();
		int s = value.indexOf(SET_LEFT);
		int e = value.lastIndexOf(SET_RIGHT);
		
		if(s>=0&&e==value.length()-1){
			String nvalue = value.substring(s+1, e);
			//!!!if(value==null)return null;
			if(nvalue==null){
				try {
					throw this.getArgException("value", "interpreteSet(value)", "Invalid statement: "+nvalue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			value = nvalue.trim();
			
			char[] dots = {SET_DOT};
			String[] items = value.split(new String(dots));
			if(items==null){
				try {
					throw this.getArgException("value", "interpreteSet(value)", "Invalid statement: "+value);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			LSet set = this.creator.createSet();
			for(int i=0;i<items.length;i++){
				String item = items[i];
				if(item==null||item.trim().length()==0)continue;
				set.getValues().add(this.interpreteObject(item.trim()));
			}
			return set;
		}
		else return null;
	}
	LRelationSet interpreteRelationSet(ValueUnit unit){
		if(unit==null){
			try {
				throw this.getArgException("unit", "interpreteRelationSet(unit)", "Null input");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.interpreteRelationSet(unit.getValue());
	}
	@SuppressWarnings("static-access")
	LRelationSet interpreteRelationSet(String value){
		if(value==null||value.trim().length()==0)return null;
		
		value = value.trim();
		int s = value.indexOf(SET_LEFT);
		int e = value.lastIndexOf(SET_RIGHT);
		
		if(s>=0&&e==value.length()-1){
			String nvalue = value.substring(s+1, e);
			//!!!if(value==null)return null;
			if(nvalue==null){
				try {
					throw this.getArgException("value", "interpreteSet(value)", "Invalid statement: "+value);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			value = nvalue.trim();
			
			char[] dots = {SET_DOT};
			String[] items = value.split(new String(dots));
			if(items==null){
				try {
					throw this.getArgException("value", "interpreteSet(value)", "Invalid statement: "+value);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			LRelationSet set = this.creator.createRelationSet();
			for(int i=0;i<items.length;i++){
				String item = items[i];
				if(item==null||item.trim().length()==0)continue;
				set.getRelations().add(this.interpreteRelation(item.trim()));
			}
			return set;
		}
		else return null;
	}
	
}
