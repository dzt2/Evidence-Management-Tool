package cn.edu.buaa.sei.logicAC.meta.common.impl.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.FlexibleOperator;

public abstract class FlexibleOperatorImpl extends OperatorImpl implements FlexibleOperator{
	static final int INIT_SIZE = 8;
	static final int TIMES = 4;
	int len=0;
	
	FlexibleOperatorImpl(){this.operands = new Computable[INIT_SIZE];}

	@Override
	public int getCurrentSize() {return this.len;}

	@Override
	public void addOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new NullPointerException("Operand cannot be null in the operator");
		if(this.len>=MAX_OPERANDS)
			throw new Exception("The operator has been flowed out: "+this.len);
		if(this.len>=this.operands.length){
			Computable[] list = new Computable[this.operands.length*TIMES];
			for(int i=0;i<this.len;i++)
				list[i]=this.operands[i];
			this.operands=list;
		}
		
		this.operands[this.len++]=operand;
	}

	@Override
	public void removeOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new NullPointerException("Null operand is not in the operator.");
		
		int i;
		for(i=0;i<this.len;i++)
			if(operand==this.operands[i])break;
		
		if(i>=this.len)
			throw new Exception("Operand is not in the operator");
		
		for(int j=i;j<this.len-1;j++)
			this.operands[j]=this.operands[j+1];
		this.len--;
	}

	@Override
	public boolean containOperand(Computable operand) {
		if(operand==null)return false;
		for(int i=0;i<this.len;i++)
			if(this.operands[i]==operand)return true;
		return false;
	}

}
