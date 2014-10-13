package cn.edu.buaa.sei.SVI.logic.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.logic.AtLeast;
import cn.edu.buaa.sei.SVI.logic.DiscourseDomain;

public class AtLeastImpl extends QuantifierOperatorImpl implements AtLeast{
	
	int lower = 0;

	/**
	 * Default: lower=0
	 * */
	protected AtLeastImpl(DiscourseDomain domain, LogicStruct scope,
			CompositeStruct container) throws Exception {super(domain, scope, container);}

	@Override
	public int getLowerBound() {
		return this.lower;
	}
	@Override
	public void setLowerBound(int lower) throws Exception {
		if(lower<0)
			throw new Exception("Invalid Lower Bound: "+lower);
		this.lower=lower;
	}
	
	@Override
	public String toString(){
		return "AtLeast("+this.lower+","+domain.toString()+","+scope.toString()+")";
	}
}
