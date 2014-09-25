package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.expr.FlexibleOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public abstract class FlexibleLogicOperatorImpl extends LogicOperatorImpl implements FlexibleOperator{
	public static final int MAX_OPERANDS = 256;
	public static final int INIT_SIZE = 16;
	public static final int TIMES = 4;
	
	int len=0;
	
	FlexibleLogicOperatorImpl(){
		super();
		this.operands = new LogicFormulation[INIT_SIZE];
	}
	
	@Override
	public int getCurrentSize() {return this.len;}
	@Override
	public void addOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		if(!(operand instanceof LogicFormulation))
			throw new ClassCastException("Operand should be LogicFormulation");
		if(this.len>=MAX_OPERANDS)
			throw new Exception("Out of limitation: "+this.len);
		if(this.len>=this.operands.length){
			LogicFormulation[] list = new LogicFormulation[this.operands.length*TIMES];
			for(int i=0;i<this.operands.length;i++)
				list[i]=this.operands[i];
		}
		
		this.operands[this.len++]=(LogicFormulation) operand;
	}

	@Override
	public void removeOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is not in the operator");
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
			if(operand==this.operands[i])return true;
		return false;
	}

}
