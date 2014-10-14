package cn.edu.buaa.sei.SVI.numeric.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.extend.NumericStruct;
import cn.edu.buaa.sei.SVI.numeric.Division;

public class DivisionImpl extends BinaryNumericOperatorImpl implements Division{

	DivisionImpl(NumericStruct left, NumericStruct right,
			CompositeStruct container) throws Exception {
		super(left, right, container);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return this.left.toString()+" / "+this.right.toString();
	}
}
