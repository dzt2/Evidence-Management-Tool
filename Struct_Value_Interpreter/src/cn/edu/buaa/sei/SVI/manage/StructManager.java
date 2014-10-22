package cn.edu.buaa.sei.SVI.manage;

import java.util.Set;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public interface StructManager {
	/*public Struct get(String id) throws Exception;
	public void put(String id,Struct element) throws Exception;
	
	public boolean contain(String id);
	public boolean contain(Struct element);
	
	public String getIdOf(Struct element) throws Exception;
	public Set<String> getAllIDs();
	public Set<Struct> getAllStructs();
	
	public void clearSpace();*/
	
	public boolean contain(Struct struct);
	public Set<Struct> getTopStructs();
	public void putTopStruct(Struct struct) throws Exception;
	public void removeTopStruct(Struct struct) throws Exception;
	public void clear();
}
