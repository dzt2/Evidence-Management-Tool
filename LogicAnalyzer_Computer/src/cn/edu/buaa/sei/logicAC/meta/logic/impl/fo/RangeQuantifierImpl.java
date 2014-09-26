package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RangeQuantifier;

public class RangeQuantifierImpl extends QuantifierOperatorImpl implements RangeQuantifier{
	int lower,upper;
	
	RangeQuantifierImpl(DiscourseDomain domain,LogicFormulation scope,int lower,int upper) throws Exception{
		super(domain,scope);
		this.setBound(lower, upper);
	}

	@Override
	public int getLowerBound() {return this.lower;}
	@Override
	public int getUpperBound() {return this.upper;}
	@Override
	public void setBound(int lower, int upper) throws Exception {
		if(lower<0)
			throw new Exception("Invalid Lower Bound: "+lower);
		if(upper<0&&upper!=UNBOUNDED)
			throw new Exception("Invalid Upper Bound: "+upper);
		if(upper!=UNBOUNDED&&upper<lower)
			throw new Exception("Invalid Range: ["+lower+", "+upper+"]");
		
		this.lower=lower;
		this.upper=upper;
	}
	
}
