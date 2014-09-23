package cn.edu.buaa.sei.logicAC.meta.common.impl;

import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.ComputedContext;
import cn.edu.buaa.sei.logicAC.meta.common.Variable;
import cn.edu.buaa.sei.logicAC.meta.common.VariablePool;

public class PackagedVariablePool implements ComputedContext{
	VariablePool pool;
	
	public PackagedVariablePool(VariablePool pool) throws Exception{
		if(pool==null)throw new Exception("Null pool is specified");
		this.pool=pool;
	}

	@Override
	public Iterator<Variable> iterator() {return this.pool.iterator();}

	@Override
	public int size() {return this.pool.size();}

	@Override
	public Variable getVariableByName(String name) throws Exception {return this.pool.getVariableByName(name);}

	@Override
	public Set<String> getNames() {return this.pool.getNames();}

	@Override
	public void putVariable(Variable var) throws Exception {this.pool.putVariable(var);}

	@Override
	public void deleteVariable(Variable var) throws Exception {this.pool.deleteVariable(var);}

	@Override
	public boolean containVariable(Variable var) {return this.pool.containVariable(var);}
}
