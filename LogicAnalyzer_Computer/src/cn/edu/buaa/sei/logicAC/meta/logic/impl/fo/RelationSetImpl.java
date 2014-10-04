package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import java.util.HashMap;
import java.util.Map;

import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSet;

public class RelationSetImpl implements RelationSet{
	
	Map<String,Relation> map = new HashMap<String,Relation>();
	
	static class Relation {
		Object[] elements;
		public Relation(Object[] elements) throws Exception{
			if(elements==null)throw new Exception("Null elements is invalid");
			this.elements=elements;
		}
		public Object[] getElements(){return this.elements;}
		public int getDimension(){return this.elements.length;}
	}

	private String getID(Object[] elements){
		if(elements==null)return null;
		StringBuilder code = new StringBuilder();
		for(int i=0;i<elements.length;i++){
			code.append(elements[i].hashCode());
			if(i!=elements.length-1)
				code.append("-");
		}
		return code.toString();
	}
	
	@Override
	public boolean containRelation(Object[] elements) {
		String id = this.getID(elements);
		if(id==null||!this.map.containsKey(id))
			return false;
		else return true;
	}
	@Override
	public void addRelation(Object[] elements) throws Exception {
		String id = this.getID(elements);
		
		if(id==null)
			throw new Exception("Null Elements are invalid");
		if(this.map.containsKey(id))
			throw new Exception("Relation has been added");
		
		this.map.put(id, new Relation(elements));
	}
	@Override
	public void removeRelation(Object[] elements) throws Exception {
		String id = this.getID(elements);
		
		if(id==null)
			throw new Exception("Null Elements are invalid");
		if(!this.map.containsKey(id))
			throw new Exception("Relation has not been added");
		
		this.map.remove(id);
	}
	@Override
	public void clearRelations() {this.map.clear();}
}
