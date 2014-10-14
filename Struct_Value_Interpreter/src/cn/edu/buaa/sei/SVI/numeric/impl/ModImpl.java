package cn.edu.buaa.sei.SVI.numeric.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.extend.NumericStruct;
import cn.edu.buaa.sei.SVI.numeric.Mod;

public class ModImpl extends BinaryNumericOperatorImpl implements Mod{

	ModImpl(NumericStruct left, NumericStruct right, CompositeStruct container)
			throws Exception {
		super(left, right, container);
	}

	@Override
	public String toString(){
		return this.left.toString()+" +% "+this.right.toString();
	}
}
