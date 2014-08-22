package cn.edu.buaa.sei.emt.logic.io;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.emt.logic.creator.ValueCreator;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public class TextualValueInterpreter implements ValueInterpreter{
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
	ValueCreator creator = new ValueCreator("value_creator");
	public TextualValueInterpreter(String name){this.name=name;}	
	
	/*
	 *	Tool Functions 
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
	 *	Core Functions 
	 */
	@Override
	public Boolean isValid(String text) throws Exception {
		// TODO Auto-generated method stub
		if(text==null){
			throw this.getArgException("text", "isValid(text)", "Null text is invalid");
		}
		
		ValueType type = this.getType(text);
		if(type==null){
			throw this.getArgException("text", "isValid(text)", "Type interpreted failed");
		}
		
		text=text.trim();
		
		if(type==ValueType.LObject){return true;}
		else if(type==ValueType.LRelation){
			
			int s = text.indexOf(RELATION_LEFT);
			int e = text.lastIndexOf(RELATION_RIGHT);
			text = text.substring(s+1, e);
			
			char[] dot = {RELATION_DOT};
			String relation_dot = new String(dot);
			
			String[] items = text.split(relation_dot);
			if(items==null||items.length==0){throw this.getArgException("text", "isValid(text)", "relation is empty");}
			
			for(int i=0;i<items.length;i++){
				ValueType item_type = this.getType(items[i]);
				if(item_type!=ValueType.LObject)
					throw this.getArgException("items["+i+"]", "isValid(text)", 
							"items["+i+"] is not object: "+items[i]);
			}
			return true;
		}
		else if(type==ValueType.LSet){
			
			int s = text.indexOf(SET_LEFT);
			int e = text.lastIndexOf(SET_RIGHT);
			
			text = text.substring(s+1,e);
			
			char[] dot = {SET_DOT};
			String set_dot = new String(dot);
			
			String[] items = text.split(set_dot);
			if(items==null||items.length==0)return true;
			
			for(int i=0;i<items.length;i++){
				ValueType item_type = this.getType(items[i]);
				if(item_type!=ValueType.LObject)
					throw this.getArgException("items["+i+"]", "isValid(text)", 
							"items["+i+"] is not object: "+items[i]);
			}
			return true;
		}
		else if(type==ValueType.LRelationSet){
			int s = text.indexOf(SET_LEFT);
			int e = text.lastIndexOf(SET_RIGHT);
			
			text = text.substring(s+1,e);
			
			char[] dot = {SET_DOT};
			String set_dot = new String(dot);
			
			String[] items = text.split(set_dot);
			if(items==null||items.length==0)return true;
			
			for(int i=0;i<items.length;i++){
				ValueType item_type = this.getType(items[i]);
				if(item_type!=ValueType.LRelation)
					throw this.getArgException("items["+i+"]", "isValid(text)", 
							"items["+i+"] is not relation: "+items[i]);
			}
			return true;
		}
		else{throw this.getArgException("text", "isValid(text)", "Unknown Type: "+type);}
	}

	@Override
	public ValueType getType(String text) throws Exception {
		// TODO Auto-generated method stub
		if(text==null)return null;
		text = text.trim();
		
		int s = text.indexOf(SET_LEFT);
		int e = text.lastIndexOf(SET_RIGHT);
		if(s>=0&&e==text.length()-1){
			//text = text.substring(s+1,e);
			
			String name = text.substring(0, s).trim();
			if(name.equals(RELATION_NAME))return ValueType.LRelationSet;
			else return ValueType.LSet;
			
			/*char[] dots = {SET_DOT};
			String dot = new String(dots);
			
			String[] items = text.split(dot);
			Boolean exist_relation = false;
			Boolean exist_object = false;
			
			for(int i=0;i<items.length;i++){
				ValueType item_type = this.getType(items[i]);
				if(item_type==null){
					throw this.getArgException("items["+i+"]", 
								"getType(text)", "The "+i+"th element \""+items[i]+"\" is invalid.");
				}
				else if(item_type == ValueType.LObject)exist_object=true;
				else if(item_type == ValueType.LRelation)exist_relation=true;
				else{
					throw this.getArgException("items["+i+"]", "getType(text)", 
								"nesting set is invalid: \""+items[i]+"\"");
				}
			}
			
			if(!exist_object&&!exist_relation)return ValueType.LSet;
			else if(exist_object&&!exist_relation)return ValueType.LSet;
			else if(!exist_object&&exist_relation)return ValueType.LRelationSet;
			else{
				throw this.getArgException("text", "getType(text)", 
							"text \""+text+"\" is invalid set/relationset format.");
			}*/
			
		}
		
		s = text.indexOf(RELATION_LEFT);
		e = text.lastIndexOf(RELATION_RIGHT);
		
		if(s>=0&&e==text.length()-1){return ValueType.LRelation;}
		
		return ValueType.LObject;
	}

	@SuppressWarnings("static-access")
	@Override
	public Value interprete(String text) throws Exception{
		// TODO Auto-generated method stub
		if(!this.isValid(text)){
			throw this.getArgException("text", "interprete(text)", "generate Value failed: "+text);
		}
		
		text = text.trim();
		
		ValueType type = this.getType(text);
		if(type==ValueType.LObject){
			LObject val = null;
			String id = text.trim();
			
			if(TRUE.equals(id))return this.creator.getTrue();
			if(FALSE.equals(id))return this.creator.getFalse();
			
			if(this.creator.containObject(id))return this.creator.getObject(id);
			val = this.creator.createObject(id);
			return val;
		}
		else if(type==ValueType.LRelation){
			int s = text.indexOf(RELATION_LEFT);
			int e = text.lastIndexOf(RELATION_RIGHT);
			String name = text.substring(0, s).trim();
			String etext = text.substring(s+1, e).trim();
			
			char[] dot = {RELATION_DOT};
			String dots = new String(dot);
			String[] items = etext.split(dots);
			
			List<LObject> elements = new ArrayList<LObject>();
			if(items!=null){
				for(int i=0;i<items.length;i++){
					Value item = this.interprete(items[i].trim());
					if(item==null||!(item instanceof LObject))
						throw this.getArgException("items["+i+"]", "interprete(text)", 
								"items["+i+"] is invalid text in relation: "+items[i]);
					elements.add((LObject) item);
				}
			}
			
			if(this.creator.containRelation(name, elements))
				return this.creator.getRelation(name, elements);
			LRelation val = this.creator.createRelation(name,elements);
			return val;
		}
		else if(type==ValueType.LSet){
			int s = text.indexOf(SET_LEFT);
			int e = text.indexOf(SET_RIGHT);
			//String name = text.substring(0, s).trim();
			String etext = text.substring(s+1, e).trim();
			
			char[] dot = {SET_DOT};
			String dots = new String(dot);
			String[] items = etext.split(dots);
			
			List<LObject> elements = new ArrayList<LObject>();
			if(items!=null){
				for(int i=0;i<items.length;i++){
					Value item = this.interprete(items[i]);
					if(item==null||!(item instanceof LObject))
						throw this.getArgException("items["+i+"]", "interprete(text)", 
								"items["+i+"] is invalid text in relation: "+items[i]);
					elements.add((LObject) item);
				}
			}
			
			LSet val = this.creator.createSet();
			for(LObject element:elements)
				val.getValues().add(element);
			return val;
		}
		else if(type==ValueType.LRelationSet){
			int s = text.indexOf(SET_LEFT);
			int e = text.indexOf(SET_RIGHT);
			//String name = text.substring(0, s).trim();
			String etext = text.substring(s+1, e).trim();
			
			char[] dot = {SET_DOT};
			String dots = new String(dot);
			String[] items = etext.split(dots);
			
			List<LRelation> elements = new ArrayList<LRelation>();
			if(items!=null){
				for(int i=0;i<items.length;i++){
					Value item = this.interprete(items[i]);
					if(item==null||!(item instanceof LRelation))
						throw this.getArgException("items["+i+"]", "interprete(text)", 
								"items["+i+"] is invalid text in relation: "+items[i]);
					elements.add((LRelation) item);
				}
			}
			
			LRelationSet relations = this.creator.createRelationSet();
			for(LRelation element:elements)
				relations.getRelations().add(element);
			
			return relations;
		}
		else return null;
	}

	@Override
	public String reInterprete(Value val) throws Exception{
		// TODO Auto-generated method stub
		if(val==null)return null;
		StringBuilder code = new StringBuilder();
		
		if(val instanceof LObject){code.append(((LObject) val).getId());}
		else if(val instanceof LRelation){
			code.append(((LRelation) val).getName());
			code.append(RELATION_LEFT);
			
			List<LObject> elements = ((LRelation) val).getElements();
			for(int i=0;i<elements.size();i++){
				code.append(this.reInterprete(elements.get(i)));
				if(i!=elements.size()-1)
					code.append(RELATION_DOT);
			}
			
			code.append(RELATION_RIGHT);
		}
		else if(val instanceof LSet){
			code.append(SET_LEFT);
			List<LObject> elements = ((LSet) val).getValues();
			for(int i=0;i<elements.size();i++){
				code.append(this.reInterprete(elements.get(i)));
				if(i!=elements.size()-1)
					code.append(SET_DOT);
			}
			code.append(SET_RIGHT);
		}
		else if(val instanceof LRelationSet){
			code.append(SET_LEFT);
			List<LRelation> elements = ((LRelationSet) val).getRelations();
			for(int i=0;i<elements.size();i++){
				code.append(this.reInterprete(elements.get(i)));
				if(i!=elements.size()-1)
					code.append(SET_DOT);
			}
			code.append(SET_RIGHT);
		}
		
		return code.toString();
	}

}
