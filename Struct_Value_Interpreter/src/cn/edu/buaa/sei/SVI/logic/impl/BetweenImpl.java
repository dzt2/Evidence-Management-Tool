package cn.edu.buaa.sei.SVI.logic.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.logic.Between;
import cn.edu.buaa.sei.SVI.logic.DiscourseDomain;

public class BetweenImpl extends QuantifierOperatorImpl implements Between{
	
	int lower=0,upper=Between.UNBOUNDED;

	/**
	 * Default: lower=0, upper=UNBOUNDED
	 * */
	protected BetweenImpl(DiscourseDomain domain, LogicStruct scope,
			CompositeStruct container) throws Exception {
		super(domain, scope, container);
	}

	@Override
	public int getLowerBound() {
		return this.lower;
	}

	@Override
	public int getUpperBound() {
		return this.upper;
	}

	@Override
	public void setBound(int lower, int upper) throws Exception {
		if(lower<0)
			throw new Exception("Invalid Lower Bound: "+lower);
		if(upper<0&&upper!=Between.UNBOUNDED)
			throw new Exception("Invalid Upper Bound: "+upper);
		
		this.lower=lower;this.upper=upper;
	}

}
