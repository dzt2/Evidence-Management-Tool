package cn.edu.buaa.sei.logicAC.meta.common.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.Variable;
import cn.edu.buaa.sei.logicAC.meta.common.VariablePool;

public class DynamicVariableList implements VariablePool{
	List<Variable> list = new ArrayList<Variable>();
	Set<String> names = new HashSet<String>();
	
	public DynamicVariableList(){}

	@Override
	public Iterator<Variable> iterator() {return this.list.iterator();}

	@Override
	public int size() {return this.list.size();}

	@Override
	public Variable getVariableByName(String name) throws Exception {
		if(name==null)
			throw new Exception("Null name must not be contained in the pool");
		
		int i;
		for(i=0;i<this.list.size();i++)
			if(name.equals(this.list.get(i).getName()))break;
		if(i>=this.list.size())
			throw new Exception(name+" has not been appended in the pool");
		
		return this.list.get(i);
	}

	@Override
	public Set<String> getNames() {return this.names;}

	@Override
	public void putVariable(Variable var) throws Exception {
		if(var==null)throw new Exception("Null variable is invalid");
		if(this.list.contains(var))return;
		if(this.names.contains(var.getName()))
			throw new Exception("Name conflict : "+var.getName());
		
		this.list.add(var);
		this.names.add(var.getName());
	}

	@Override
	public void deleteVariable(Variable var) throws Exception {
		if(!this.list.contains(var))
			throw new Exception("Variable has not been defined in the pool");
		
		this.list.remove(var);
		this.names.remove(var.getName());
	}

	@Override
	public boolean containVariable(Variable var) {return this.list.contains(var);}

}
