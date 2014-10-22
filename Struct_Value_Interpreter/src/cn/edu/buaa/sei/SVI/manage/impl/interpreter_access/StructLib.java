package cn.edu.buaa.sei.SVI.manage.impl.interpreter_access;

import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.sei.SVI.manage.StructClassLib;

public class StructLib implements StructClassLib{
	
	public static StructClassLib struct_lib = new StructLib();
	
	public static StructClassLib getStructLibrary(){return struct_lib;}
	
	private StructLib(){}
	
	@SuppressWarnings("rawtypes")
	Set<Class> types = new HashSet<Class>();

	@SuppressWarnings("rawtypes")
	@Override
	public synchronized Set<Class> getLoadedStructClasses() {return this.types;}

	@SuppressWarnings("rawtypes")
	@Override
	public synchronized boolean isLoaded(Class stype) {
		if(stype==null)return false;
		else return this.types.contains(stype);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public synchronized void load(Class stype) throws Exception {
		if(stype==null)throw new Exception("Null type is invalid");
		this.types.add(stype);
	}

}
