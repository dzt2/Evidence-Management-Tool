package cn.edu.buaa.exLmf.manager.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.exLmf.manager.IObjectSpace;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LFactory;
import cn.edu.buaa.exLmf.metamodel.LObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.impl.LMFException;

public class ObjectSpace implements IObjectSpace{
	String name;
	LPackage container;
	
	Map<Integer,LClassObject> objMap = new HashMap<Integer,LClassObject>();
	Map<LClass,Set<LClassObject>> typeMap = new HashMap<LClass,Set<LClassObject>>();
	
	public ObjectSpace(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getException(String func,String arg,String reason){
		return LMFException.create("LMFException", this.getClass().getName(), func, arg, reason);
	}

	@Override
	public void register(LPackage p) {this.container=p;}
	@Override
	public Boolean isInstancable(LClassifier type) {
		if(type==null)return false;
		if(!this.container.containType(type))return false;
		if(type instanceof LClass){
			if(((LClass) type).isAbstract())return false;
		}
		return true;
	}

	@Override
	public LClassObject createClassObject(LClass type) {
		if(!this.isInstancable(type))return null;
		
		LFactory factory = this.container.getFactory();
		LClassObject obj = factory.create(type);
		
		this.objMap.put(obj.hashCode(), obj);
		
		if(!this.typeMap.containsKey(type))
			this.typeMap.put(type, new HashSet<LClassObject>());
		Set<LClassObject> objs = this.typeMap.get(type);
		objs.add(obj);
		
		return obj;
	}
	@Override
	public LDataObject createDataObject(LDataType type, String code) {
		if(!this.isInstancable(type))return null;
		
		LFactory factory = this.container.getFactory();
		LDataObject obj = factory.create(type, code);
		
		return obj;
	}

	@Override
	public Boolean removeObject(LObject obj) {
		if(obj!=null&&this.objMap.containsKey(obj.hashCode())){
			this.objMap.remove(obj.hashCode());
			this.typeMap.get(obj.type()).remove(obj);
			return true;
		}
		return false;
	}
	@Override
	public Boolean containObject(LObject obj) {
		if(obj==null)return false;
		return this.objMap.containsKey(obj.hashCode());
	}
	@Override
	public Boolean containObject(int id) {return this.objMap.containsKey(id);}
	@Override
	public Integer getIDof(LObject obj) {
		if(obj==null||!this.objMap.containsKey(obj.hashCode()))return null;
		else return obj.hashCode();
	}

	@Override
	public LObject getObject(int id) {
		if(this.containObject(id))return this.objMap.get(id);
		else return null;
	}

	@Override
	public Set<LClassObject> getObjects(LClass type) {
		if(this.typeMap.containsKey(type))
			return this.typeMap.get(type);
		return null;
	}
	@Override
	public void clearSpace() {
		this.objMap.clear();
		this.typeMap.clear();
	}

}
