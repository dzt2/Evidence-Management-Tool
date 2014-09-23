package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.Operator;

public abstract class FixedOperator implements Operator{
	int dimension;
	Computable[] parameters;
	
	protected FixedOperator(int dimension) throws Exception{
		if(dimension<=0)
			throw new Exception("Invalid dimension for fixed-demension operator: "+dimension);
		this.dimension=dimension;
		this.parameters=new Computable[this.dimension];
	}

	@Override
	public int getDimension() {return this.dimension;}

	@Override
	public Computable[] getParameters() {return this.parameters;}

	@Override
	public void setParameters(Computable[] parameters) throws Exception {
		if(parameters==null)throw new Exception("Null parameters could not be applied");
		if(parameters.length!=this.dimension)throw new Exception("Invalid dimension of the parameters: "+parameters.length);
		this.parameters=parameters;
	}

	@Override
	public Computable getParameter(int i) throws Exception {
		if(i<0||i>=this.dimension)
			throw new Exception("Out of range in parameter list: "+i);
		return this.parameters[i];
	}
}
