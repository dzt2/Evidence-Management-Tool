package cn.edu.buaa.sei.emt.logic.predicate.compute;

import java.util.HashMap;
import java.util.Map;

import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationFactory;

public class ValueCreator {
	String creator_name;
	Map<String,LObject> objects = new HashMap<String,LObject>();
	static BooleanObject TRUE,FALSE;
	Map<String,LRelation> relations = new HashMap<String,LRelation>();
	
	// BooleanObject Initial
	static{
		TRUE = LogicFormulationFactory.createBooleanObject();
		FALSE = LogicFormulationFactory.createBooleanObject();
		TRUE.setId("true");TRUE.setBool_val(true);
		FALSE.setId("false");FALSE.setBool_val(false);
	}
	
	public ValueCreator(String creator_name){
		this.creator_name=creator_name;
	}
	
	/*
	 *	Error Process 
	 */
	Exception generateArgErrors(String arg,String function, String reason){
		StringBuilder msg = new StringBuilder();
		msg.append("Error Type: Argument Errors\n");
		msg.append("Location: "+function+"\n");
		msg.append("Error Argument: "+arg+"\n");
		//msg.append("Conflict Name: "+name + "\n");
		//Type type = this.map.get(name).type();
		msg.append("Reason: "+reason);
		return new Exception(msg.toString());
	}
	String generateLRelationID(LRelation r){
		if(r==null)return null;
		return this.generateLRelationID(r.getName(), (LObject[]) r.getElements().toArray());
	}
	String generateLRelationID(String name,LObject[] elements){
		if(name!=null||elements!=null){
			StringBuilder id = new StringBuilder();
			id.append(name).append("<");
			for(int i=0;i<elements.length;i++){
				if(elements[i]==null)
					id.append("null");
				else id.append(elements[i].getId());
				
				if(i!=elements.length-1)
					id.append(", ");
			}
			id.append(">");
			
			return id.toString();
		}
		return null;
	}
	
	
	/*
	 * 	Creator
	 * 		1. LObject
	 * 		2. BooleanObject
	 * 		3. LSet *
	 * 		4. LRelation
	 * 		5. LRelationSet *
	 */
	public LObject createLObject(String id){
		if(this.objects.containsKey(id))
			try {
				throw this.generateArgErrors("id", "createLObject", id+" has been used for LObject.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		
		// Create LObject
		LObject o = LogicFormulationFactory.createLObject();
		o.setId(id);
		this.objects.put(id, o);
		
		return o;
	}
	public LObject getLObject(String id){
		if(this.objects.containsKey(id))
			return this.objects.get(id);
		return null;
	}
	public void releaseLObjectID(String id){
		if(this.objects.containsKey(id))
			this.objects.remove(id);
	}
	
	public BooleanObject getTrue(){return TRUE;}
	public BooleanObject getFalse(){return FALSE;}
	
	public LRelation createLRelation(String name,LObject[] elements){
		/*
		 *	Faults:
		 *		1) Null Elements
		 *		2) Empty Elements
		 *		3) ID Conflicts 
		 */
		if(elements==null)
			try {
				throw this.generateArgErrors("elements", "createLRelation", 
						"try to call createLRelation("+name+", null)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		if(elements.length<1)
			try {
				throw this.generateArgErrors("elements", "createLRelation", 
						"try to call createLRelation("+name+", empty_elements)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		
		String id = this.generateLRelationID(name, elements);
		if(this.relations.containsKey(id))
			try {
				throw this.generateArgErrors("name+elements", "createLRelation", 
						"LRelation id \""+id+"\" has been used.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		
		// create LRelation
		LRelation r = LogicFormulationFactory.createLRelation();
		r.setName(name);
		for(int i=0;i<elements.length;i++)
			r.getElements().add(elements[i]);
		
		this.relations.put(id, r);
		return r;
	}
	public LRelation getLRelation(String name,LObject[] elements){
		if(name!=null||elements!=null){
			StringBuilder id = new StringBuilder();
			id.append(name).append("<");
			for(int i=0;i<elements.length;i++){
				if(elements[i]==null)
					id.append("null");
				else id.append(elements[i].getId());
				
				if(i!=elements.length-1)
					id.append(", ");
			}
			id.append(">");
			
			return this.relations.get(id.toString());
		}
		return null;
	}
	public void releaseLRelationID(LRelation r){
		String id = this.generateLRelationID(r);
		if(this.relations.containsKey(id))
			this.relations.remove(id);
	}
	
	public LSet createLSet(){return LogicFormulationFactory.createLSet();}
	public LRelationSet createLRelationSet(){return LogicFormulationFactory.createLRelationSet();}
	
}
