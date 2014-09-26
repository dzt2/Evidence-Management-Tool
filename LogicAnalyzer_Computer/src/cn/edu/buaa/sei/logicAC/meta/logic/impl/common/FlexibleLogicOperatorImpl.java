package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.FlexibleLogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public abstract class FlexibleLogicOperatorImpl extends LogicOperatorImpl implements FlexibleLogicOperator{
	public static final int INIT_SIZE = 8;
	public static final int TIMES = 4;
	int len=0;
	
	FlexibleLogicOperatorImpl(){this.operands=new LogicFormulation[INIT_SIZE];}

	@Override
	public int getCurrentSize() {return this.len;}

	@Override
	public void addOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		if(!(operand instanceof LogicFormulation))
			throw new ClassCastException("Invalid type of operand: "
		+operand.getClass().getName()+" hope to be LogicFormulation");
		
		this.addOperand((LogicFormulation)operand);
	}
	@Override
	public void removeOperand(Computable operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		if(!(operand instanceof LogicFormulation))
			throw new ClassCastException("Invalid type of operand: "
		+operand.getClass().getName()+" hope to be LogicFormulation");
		
		this.removeOperand((LogicFormulation)operand);
	}
	@Override
	public boolean containOperand(Computable operand) {
		if(operand==null)
			return false;
		if(!(operand instanceof LogicFormulation))
			return false;
		return this.containOperand((LogicFormulation)operand);
	}

	@Override
	public void addOperand(LogicFormulation operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		
		if(this.len>=MAX_OPERANDS)
			throw new Exception("Out of limitation: "+this.len);
		if(this.len>=this.operands.length){
			LogicFormulation[] list = new LogicFormulation[this.operands.length*TIMES];
			for(int i=0;i<this.operands.length;i++)
				list[i]=this.operands[i];
			this.operands=list;
		}
		
		this.operands[this.len++]=operand;
	}
	@Override
	public void removeOperand(LogicFormulation operand) throws Exception {
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
	public boolean containOperand(LogicFormulation operand) {
		if(operand==null)return false;
		for(int i=0;i<this.len;i++)
			if(operand==this.operands[i])
				return true;
		return false;
	}

}
