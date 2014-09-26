package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.FreeVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.impl.var.base.SetVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.FreeVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;

public class DiscourseDomainImpl extends SetVariableImpl implements DiscourseDomain{
	FreeVariable iter;

	DiscourseDomainImpl(String name) throws Exception {
		super(name);
		this.iter=new FreeVariableImpl(name+".iter");
	}

	@Override
	public FreeVariable getIterator() {return this.iter;}

}
