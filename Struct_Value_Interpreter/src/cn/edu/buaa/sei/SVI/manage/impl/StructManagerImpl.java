package cn.edu.buaa.sei.SVI.manage.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class StructManagerImpl implements StructManager{
	
	Map<String,Struct> map = new HashMap<String,Struct>();
	Map<Struct,String> rmap = new HashMap<Struct,String>();
	
	@Override
	public Struct get(String id) throws Exception {
		if(id==null)
			throw new Exception("Null id is invalid");
		if(!this.map.containsKey(id))
			throw new Exception("Unknown id: "+id);
		return this.map.get(id);
	}

	@Override
	public void put(String id, Struct element) throws Exception {
		if(id==null||element==null)
			throw new Exception("Null id|element is invalid");
		if(this.contain(id))
			throw new Exception(id+" has been used in this space");
		
		this.map.put(id, element);
		
		if(this.rmap.containsKey(element)){
			this.rmap.remove(element);
		}
		this.rmap.put(element, id);
	}

	@Override
	public boolean contain(String id) {
		if(id==null)return false;
		else return this.map.containsKey(id);
	}
	@Override
	public boolean contain(Struct element) {
		if(element==null)return false;
		else return this.map.containsValue(element);
	}

	@Override
	public String getIdOf(Struct element) throws Exception {
		if(element==null)
			throw new Exception("Null element is invalid");
		else if(!this.contain(element))
			throw new Exception("Undefined Struct: "+element.getClass().getCanonicalName()+"{"+element.hashCode()+"}");
		else return this.rmap.get(element);
	}

	@Override
	public Set<String> getAllIDs() {return this.map.keySet();}
	@Override
	public Set<Struct> getAllStructs() {return this.rmap.keySet();}

	@Override
	public void clearSpace() {
		this.map.clear(); 
		this.rmap.clear();
	}

}
