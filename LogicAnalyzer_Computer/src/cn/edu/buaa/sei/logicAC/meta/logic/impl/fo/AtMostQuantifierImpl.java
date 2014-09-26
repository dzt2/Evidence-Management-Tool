package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.AtMostQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;

public class AtMostQuantifierImpl extends QuantifierOperatorImpl implements AtMostQuantifier{
	int upper;
	
	AtMostQuantifierImpl(DiscourseDomain domain,LogicFormulation scope,int upper) throws Exception{
		super(domain,scope);
		this.setUpperBound(upper);
	}
	@Override
	public int getUpperBound() {return this.upper;}
	@Override
	public void setUpperBound(int upper) throws Exception {
		if(upper<0&&upper!=UNBOUNDED)
			throw new Exception("Invalid upper bound: "+upper);
		this.upper=upper;
	}

}
