package cn.edu.buaa.sei.logicAC.meta.common.impl.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.PackagedContext;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class MapRunnerEnvironment extends PackagedContext implements RunnerEnvironment{
	Map<String,Variable> map = new HashMap<String,Variable>();
	RunnerEnvironment parent;

	protected MapRunnerEnvironment(Context context,RunnerEnvironment parent) throws Exception {
		super(context);
		this.parent=parent;
	}

	@Override
	public Variable getVariable(String name) throws Exception {
		if(name==null)
			throw new NullPointerException("Null name is invalid");
		if(this.map.containsKey(name))
			return this.map.get(name);
		else if(this.parent!=null)
			return this.parent.getVariable(name);
		else throw new Exception(name+" has not been defined in the environment");
	}
	@Override
	public boolean containVariable(Variable variable) {
		if(variable==null)return false;
		return this.map.containsValue(variable);
	}
	@Override
	public boolean containVariable(String name) {
		if(name==null)return false;
		else return this.map.containsKey(name);
	}
	@Override
	public void appendVariable(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable cannot be added in the environment");
		if(this.map.containsValue(variable))return;
		if(this.map.containsKey(variable.getName()))
			throw new Exception("Conflict name: "+variable.getName());
		this.map.put(variable.getName(), variable);
	}
	@Override
	public void removeVariable(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable cannot be in the environment");
		if(!this.map.containsValue(variable))
			throw new Exception("Variable has not been defined in the environment");
		this.map.remove(variable.getName());
	}
	@Override
	public Set<String> getEnvNames() {return this.map.keySet();}

	@Override
	public RunnerEnvironment getParentEnvironment() {return this.parent;}

}
