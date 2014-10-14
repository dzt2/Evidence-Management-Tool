package cn.edu.buaa.sei.SVI.group.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.function.Function;
import cn.edu.buaa.sei.SVI.core.function.impl.FunctionTemplateImpl;
import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.group.GroupFunction;
import cn.edu.buaa.sei.SVI.group.GroupFunctionTemplate;
import cn.edu.buaa.sei.SVI.group.GroupVariable;

public class GroupFunctionTemplateImpl extends FunctionTemplateImpl implements GroupFunctionTemplate{

	GroupFunctionTemplateImpl(String name, Variable[] arguments,
			CompositeStruct container) throws Exception {
		super(name, arguments, new GroupVariableImpl(OUT_NAME), container);
	}

	@Override
	public void setFunction(Function function) throws Exception {
		if(function==null)
			this.function=null;
		else if(!(function instanceof GroupFunction))
			throw new Exception("GroupFunction Required");
		else this.function=function;
	}
	@Override
	public void setFunction(GroupFunction function) {
		this.function=function;
	}
	@Override
	public GroupFunction getFunction(){
		if(this.function==null)return null;
		return (GroupFunction) this.function;
	}
	@Override
	public GroupVariable getOutput(){
		if(this.out==null)return null;
		else return (GroupVariable) this.out;
	}
	
	@Override
	public String toString(){return "Group "+super.toString();}

}
