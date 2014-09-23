package cn.edu.buaa.sei.logicAC.meta.common.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.Variable;
import cn.edu.buaa.sei.logicAC.meta.common.VariablePool;

public class HashVariableMap implements VariablePool{
	
	Map<String,Variable> map = new HashMap<String,Variable>();

	@Override
	public Iterator<Variable> iterator() {return this.map.values().iterator();}

	@Override
	public int size() {return this.map.size();}

	@Override
	public Variable getVariableByName(String name) throws Exception {
		if(name==null)
			throw new Exception("Null name must not be contained in the pool");
		
		if(!this.map.containsKey(name))
			throw new Exception(name+" has not been appended in the pool");
		
		return this.map.get(name);
	}

	@Override
	public Set<String> getNames() {return this.map.keySet();}

	@Override
	public void putVariable(Variable var) throws Exception {
		if(var==null)throw new Exception("Null variable is invalid");
		if(this.map.containsValue(var))return;
		if(this.map.containsKey(var.getName()))
			throw new Exception("Name conflict : "+var.getName());
		
		this.map.put(var.getName(), var);
	}

	@Override
	public void deleteVariable(Variable var) throws Exception {
		if(!this.map.containsValue(var))
			throw new Exception("Variable has not been defined in the pool");
		else
			this.map.remove(var.getName());
	}

	@Override
	public boolean containVariable(Variable var) {return this.map.containsValue(var);}

}
