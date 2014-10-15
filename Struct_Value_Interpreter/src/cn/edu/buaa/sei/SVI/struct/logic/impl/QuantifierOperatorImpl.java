package cn.edu.buaa.sei.SVI.struct.logic.impl;

import cn.edu.buaa.sei.SVI.struct.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.QuantifierOperator;

public abstract class QuantifierOperatorImpl extends LogicOperatorImpl implements QuantifierOperator{
	
	DiscourseDomain domain;
	LogicStruct scope;

	/**
	 * Children: [domain, scope]
	 * */
	protected QuantifierOperatorImpl(DiscourseDomain domain,
			LogicStruct scope,CompositeStruct container) throws Exception {
		super(container);
		
		if(domain==null||scope==null)
			throw new Exception("Null Domain|Scope is invalid");
		
		this.domain=domain;
		this.scope=scope;
		
		this.container.addChildStruct(domain);
		this.container.addChildStruct(scope);
	}

	@Override
	public DiscourseDomain getDomain() {return this.domain;}

	@Override
	public LogicStruct getScope() {return this.scope;}

}
