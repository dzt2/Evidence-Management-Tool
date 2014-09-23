package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.Operator;

public abstract class FlexibleOperator implements Operator{
	Computable[] parameters;

	protected FlexibleOperator(Computable[] parameters) throws Exception{
		if(parameters==null)throw new Exception("Null Parameters are invalid.");
		this.parameters=parameters;
	}
	
	@Override
	public int getDimension() {return this.parameters.length;}

	@Override
	public Computable[] getParameters() {return this.parameters;}

	@Override
	public void setParameters(Computable[] parameters) throws Exception {
		if(parameters==null)throw new Exception("Null parameter of operator is invalid");
		this.parameters=parameters;
	}

	@Override
	public Computable getParameter(int i) throws Exception {
		if(i<0||i>=this.parameters.length)
			throw new Exception("Out of range from variable range [0--"+this.parameters.length+"]: "+i);
		
		return this.parameters[i];
	}

}
