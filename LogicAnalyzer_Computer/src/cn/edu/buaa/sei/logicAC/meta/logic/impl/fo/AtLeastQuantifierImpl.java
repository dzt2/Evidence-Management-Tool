package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.AtLeastQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;

public class AtLeastQuantifierImpl extends QuantifierOperatorImpl implements AtLeastQuantifier{
	int lower;
	
	AtLeastQuantifierImpl(DiscourseDomain domain,LogicFormulation scope,int lower) throws Exception{
		super(domain,scope);
		if(lower<0)
			throw new Exception("Invalid lower bound: "+lower);
		this.lower=lower;
	}
	
	@Override
	public int getLowerBound() {return this.lower;}

	@Override
	public void setLowerBound(int lower) throws Exception {
		if(lower<0)
			throw new Exception("Invalid lower bound: "+lower);
		this.lower=lower;
	}

}
