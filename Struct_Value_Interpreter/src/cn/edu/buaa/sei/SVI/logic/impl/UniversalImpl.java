package cn.edu.buaa.sei.SVI.logic.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.logic.Universal;

public class UniversalImpl extends QuantifierOperatorImpl implements Universal{

	protected UniversalImpl(DiscourseDomain domain, LogicStruct scope,
			CompositeStruct container) throws Exception {
		super(domain, scope, container);
	}

	@Override
	public String toString(){
		return "all("+this.domain.toString()+","+this.scope.toString()+")";
	}
}
