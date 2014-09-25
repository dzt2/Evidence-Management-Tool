package cn.edu.buaa.sei.logicAC.meta.common.impl.var;

import cn.edu.buaa.sei.logicAC.meta.common.var.FreeVariable;

public class FreeVariableImpl extends VariableImpl implements FreeVariable{

	public FreeVariableImpl(String name) throws Exception {
		super(name);
	}

	@Override
	public void assign(Object val) throws Exception {
		if(val==null)
			throw new NullPointerException("Variable is set to an invalid address");
		this.val=val;
	}

}
