package cn.edu.buaa.sei.SVI.numeric.impl;

import cn.edu.buaa.sei.SVI.core.variable.impl.TypedVariableImpl;
import cn.edu.buaa.sei.SVI.numeric.RealVariable;

public class RealVariableImpl extends TypedVariableImpl implements RealVariable{

	protected RealVariableImpl(String name) throws Exception {super(name, Double.class);}

	@Override
	public void assign(Number val) throws Exception {
		if(val==null)this.val=null;
		else if(!(val instanceof Double))throw new Exception("Double value required");
		else this.val=val;
	}

	@Override
	public void assign(Double val) throws Exception {
		this.val=val;
	}
	
	@Override
	public Double read() throws Exception {
		if(val==null)return null;
		else return (Double) this.val;
	}
	
}
