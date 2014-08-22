package cn.edu.buaa.sei.emt.logic.creator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationFactory;
import cn.edu.buaa.sei.lmf.ManagedObject;

public class ValueCreator {
	/*
	 *	Tool Functions 
	 */
	static final int MAX_TRY_TIMES = 16;
	Map<String,LObject> objID = new HashMap<String,LObject>();
	Map<String,LRelation> relationID = new HashMap<String,LRelation>();
	String creator_name;
	static final BooleanObject TRUE= LogicFormulationFactory.createBooleanObject(),
			FALSE= LogicFormulationFactory.createBooleanObject();
	
	static{
		TRUE.setBool_val(true);
		FALSE.setBool_val(false);
	}
	
	public ValueCreator(String creator_name){
		this.creator_name=creator_name;
	}
	
	/*
	 *	Getter and Setter. 
	 */
	public String getName(){return this.creator_name;}
	public Set<String> getObjectID(){return this.objID.keySet();}
	public Set<String> getRelationID(){return this.relationID.keySet();}
	public LObject getObject(String id){
		if(id==null||!this.objID.containsKey(id)){
			try {
				throw getArgException("id","getObject(id)",id+" has not been defined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.objID.get(id);
	}
	public LRelation getRelation(String name,List<LObject> elements){
		String id = getRelationID(name,elements);
		if(id==null){
			try {
				throw getArgException("name|elements","getRelation(name,elements)",
						"Invalid argument to generate invalid ID: "+id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(this.relationID.containsKey(id))
			return this.relationID.get(id);
		else{
			try {
				throw getArgException("name|elements","getRelation(name,elements)",
						"relation \""+id+"\" have not been created.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	public Boolean removeObject(String id){
		if(id==null||!this.objID.containsKey(id)){
			try {
				throw getArgException("id","removeObject(id)",
						"LObject \""+id+"\" have not been created.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		this.objID.remove(id);
		return true;
	}
	public Boolean removeObject(String name,List<LObject> elements){
		String id = getRelationID(name,elements);
		if(id==null){
			try {
				throw getArgException("name|elements","removeRelation(name,elements)",
						"Invalid argument to generate invalid ID: "+id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(this.relationID.containsKey(id)){
			this.relationID.remove(id);
			return true;
		}
		else{
			try {
				throw getArgException("name|elements","removeRelation(name,elements)",
						"relation \""+id+"\" have not been created.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public Boolean containObject(String id){return this.objID.containsKey(id);}
	public Boolean containRelation(String name,List<LObject> elements){
		String id = getRelationID(name,elements);
		return this.relationID.containsKey(id);
	}
	
	/*
	 *	Tool Functions 
	 */
	static Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Type: Argument Errors: ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	static String getNewID(ManagedObject obj){
		if(obj==null)return null;
		StringBuilder id = new StringBuilder();
		
		id.append(obj.type().getFullName()).append("[");
		long code = obj.hashCode()+Calendar.getInstance().getTimeInMillis();
		id.append(code).append("]");
		
		return id.toString();
	}
	String getNextID(ManagedObject obj){
		if(obj==null)return null;
		for(int i=0;i<MAX_TRY_TIMES;i++){
			String id = getNewID(obj);
			if(!objID.containsKey(id))
				return id;
		}
		try {
			throw getArgException("obj","getNextID(obj)","Object Name Space used out.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	static String getRelationID(LRelation r){
		if(r==null||r.getName()==null)return null;
		StringBuilder id = new StringBuilder();
		
		id.append(r.getName()).append("(");
		for(int i=0;i<r.getElements().size();i++){
			if(r.getElements().get(i)!=null)
				id.append(r.getElements().get(i).getId());
			else continue;
			if(i<r.getElements().size()-1)
				id.append(",");
		}
		id.append(")");
		
		return id.toString();
	}
	static String getRelationID(String name,List<LObject> elements){
		if(name==null||elements==null)return null;
		StringBuilder id = new StringBuilder();
		
		id.append(name).append("(");
		for(int i=0;i<elements.size();i++){
			if(elements.get(i)!=null)
				id.append(elements.get(i).getId());
			else continue;
			if(i<elements.size()-1)
				id.append(",");
		}
		id.append(")");
		
		return id.toString();
	}
	
	/*
	 *	Creator Functions:
	 *		1. LObject
	 *		2. BooleanObject <TRUE,FALSE>
	 *		3. LRelation
	 *		4. LSet/LRelationSet
	 */
	public LObject createObject(){
		LObject obj = LogicFormulationFactory.createLObject();
		String id = getNextID(obj);
		if(id==null)return null;
		obj.setId(id);
		objID.put(id, obj);
		return obj;
	}
	public LObject createObject(String id){
		if(id==null||objID.containsKey(id)){
			try {
				throw getArgException("id","createObject(id)","ID Conflict: "+id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LObject obj = LogicFormulationFactory.createLObject();
		obj.setId(id);
		objID.put(id, obj);
		return obj;
	}
	
	public static BooleanObject getTrue(){return TRUE;}
	public static BooleanObject getFalse(){return FALSE;}
	
	public static LSet createSet(){return LogicFormulationFactory.createLSet();}
	public static LRelationSet createRelationSet(){return LogicFormulationFactory.createLRelationSet();}
	
	public LRelation createRelation(String name,List<LObject> elements){
		if(name==null||elements==null){
			try {
				throw getArgException("name|elements","createRelation(name,elements)",
						"try to call createRelation("+name+","+elements+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		LRelation r = LogicFormulationFactory.createLRelation();
		r.setName(name);
		for(int i=0;i<elements.size();i++){
			if(elements.get(i)!=null)
				r.getElements().add(elements.get(i));
			else{
				try {
					throw getArgException("elements","createRelation(name,elements)",
							"null element is found in index: "+i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}
		
		String id = getRelationID(r);
		if(relationID.containsKey(id)){
			try {
				throw getArgException("elements","createRelation(name,elements)",
						"ID Conflicts in Relations: "+id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		relationID.put(id, r);
		return r;
	}
	public LRelation createRelation(List<LObject> elements){
		if(elements==null||elements.size()<1){
			try {
				throw getArgException("elements","createRelation()",
						"the elements cannot be null or empty!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		String name = LObject.TYPE_NAME;
		return createRelation(name,elements);
	}
	public LRelation createRelation(String name){
		List<LObject> elements = new ArrayList<LObject>();
		return createRelation(name,elements);
	}
}
