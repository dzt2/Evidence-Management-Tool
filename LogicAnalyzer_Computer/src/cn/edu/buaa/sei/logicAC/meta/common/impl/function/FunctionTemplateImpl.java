package cn.edu.buaa.sei.logicAC.meta.common.impl.function;

import cn.edu.buaa.sei.logicAC.meta.common.context.ParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.function.FunctionTemplate;

public abstract class FunctionTemplateImpl implements FunctionTemplate{
	String name;
	ParameterList parameters;
	
	protected FunctionTemplateImpl(String name,ParameterList parameters){
		if(name==null||parameters==null)
			throw new NullPointerException("Null name/parameters is invalid in defining function template");
		this.name=name;
		this.parameters=parameters;
	}
	
	@Override
	public String getName() {return this.name;}

	@Override
	public ParameterList getParameters() {return this.parameters;}

	@Override
	public void setParameters(ParameterList plist) throws Exception {
		if(plist==null)
			throw new Exception("Null ParameterList is invalid in defining function template");
		this.parameters=plist;
	}

}
