package cn.edu.buaa.sei.logicAC.meta.common.impl.context;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.context.VariablePool;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.PackagedContext;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class SetVariablePool extends PackagedContext implements VariablePool{
	Set<Variable> variables = new HashSet<Variable>();

	public SetVariablePool(Context context) throws Exception{
		super(context);
	}
	

	@Override
	public boolean containVariable(Variable variable) {
		if(variable==null)return false;
		return this.variables.contains(variable);
	}
	@Override
	public void appendVariable(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable cannot be added in the pool");
		if(this.variables.contains(variable))return;
		this.variables.add(variable);
	}
	@Override
	public void removeVariable(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable is not in Pool");
		if(!this.variables.contains(variable))
			throw new Exception("Variable is not in the pool");
		this.variables.remove(variable);
	}


	@Override
	public Iterator<Variable> iterator() {return this.variables.iterator();}

}
