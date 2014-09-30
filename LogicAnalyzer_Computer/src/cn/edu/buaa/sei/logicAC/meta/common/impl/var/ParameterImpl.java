package cn.edu.buaa.sei.logicAC.meta.common.impl.var;

import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class ParameterImpl implements Parameter{
	Variable var;
	ParameterType type=ParameterType.IN;
	
	public ParameterImpl(Variable var,ParameterType type) throws Exception{
		if(var==null||type==null)
			throw new Exception("Null arguments is invalid to be used in packaged space");
		this.var=var;
		this.type=type;
	}

	@Override
	public String getName() {return this.var.getName();}

	@Override
	public Object read() throws Exception {return this.var.read();}

	@Override
	public void assign(Object val) throws Exception {this.var.assign(val);}

	@Override
	public Object getResult() {return this.var.getResult();}

	@Override
	public void setResult(Object result) {this.var.setResult(result);}

	@Override
	public ParameterType getParameterType() {return this.type;}

	@Override
	public void setParameterType(ParameterType type) throws Exception {
		if(type==null)
			throw new Exception("Null ParameterType is invalid");
		this.type=type;
	}
	
}
