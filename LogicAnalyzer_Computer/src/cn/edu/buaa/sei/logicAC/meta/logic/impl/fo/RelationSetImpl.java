package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import java.util.HashMap;
import java.util.Map;

import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSet;

public class RelationSetImpl implements RelationSet{
	
	Map<String,Relation> map = new HashMap<String,Relation>();
	
	private String getKey(Object src,Object trg){
		if(src==null||trg==null)return null;
		return src.hashCode()+"_"+trg.hashCode();
	}
	
	@Override
	public boolean containRelation(Object src, Object trg) {return this.map.containsKey(this.getKey(src,trg));}

	@Override
	public void addRelation(Object src, Object trg) throws Exception {
		if(src==null||trg==null)
			throw new NullPointerException("Null nodes are invalid");
		String id = this.getKey(src, trg);
		if(this.map.containsKey(id))
			throw new Exception("Relation "+id+" is invalid to be put");
		this.map.put(id, new Relation(src,trg));
	}

	@Override
	public void removeRelation(Object src, Object trg) throws Exception {
		if(src==null||trg==null)
			throw new NullPointerException("Null nodes are invalid");
		String id = this.getKey(src, trg);
		if(!this.map.containsKey(id))
			throw new Exception("Undefined relation: "+id);
		this.map.remove(id);
	}
	
	static class Relation {
		Object src,trg;
		Relation(Object src,Object trg) throws Exception {
			if(src==null||trg==null)
				throw new NullPointerException("Null nodes are invalid");
			this.src=src; this.trg=trg;
		}
		Object getSource(){return this.src;}
		Object getTarget(){return this.trg;}
	}
	
	
}
