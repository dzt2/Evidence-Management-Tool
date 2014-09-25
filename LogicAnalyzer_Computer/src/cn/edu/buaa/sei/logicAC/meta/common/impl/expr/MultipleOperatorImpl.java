package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.MultipleOperator;

public class MultipleOperatorImpl extends FixedOperatorImpl implements MultipleOperator{

	MultipleOperatorImpl(int dimension) throws Exception {super(dimension);}

	@Override
	public void setOperands(Computable[] operands) throws Exception {
		if(operands==null)
			throw new NullPointerException("Null operands could not be set in operator");
		if(operands.length!=this.dimension())
			throw new Exception("The length of operands ["+operands.length+"] does not match the dimension: "+this.dimension());
		
		for(int i=0;i<this.dimension();i++){
			if(operands[i]==null)
				throw new NullPointerException("Null operands["+i+"] could not be set in operator");
			this.operands[i]=operands[i];
		}
	}

}
