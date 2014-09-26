package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.MultipleLogicOperator;

public abstract class MultipleLogicOperatorImpl extends FixedLogicOperatorImpl implements MultipleLogicOperator{

	protected MultipleLogicOperatorImpl(int dimension) throws Exception {
		super(dimension);
		if(dimension<=2)
			throw new Exception("MultipleOperator requires at least 3 operands");
		
		this.operands = new LogicFormulation[dimension];
	}

	@Override
	public void setOperands(Computable[] operands) throws Exception {
		if(operands==null)
			throw new Exception("Null operands is invalid");
		if(operands.length!=this.operands.length)
			throw new Exception("Invalid length: "+operands.length
					+" {hope to be: "+this.operands.length+"}");
		
		for(int i=0;i<operands.length;i++){
			if(operands[i]==null)
				throw new Exception("Operands["+i+"] is null invalid");
			if(!(operands[i] instanceof LogicFormulation))
				throw new Exception("Operands["+i+"] is not LogicFormulation");
			else
				this.operands[i]=(LogicFormulation) operands[i];
		}
		
	}

	@Override
	public void setOperands(LogicFormulation[] operands) throws Exception {
		if(operands==null)
			throw new Exception("Null operands is invalid");
		if(operands.length!=this.operands.length)
			throw new Exception("Invalid length: "+operands.length
					+" {hope to be: "+this.operands.length+"}");
		
		for(int i=0;i<operands.length;i++){
			if(operands[i]==null)
				throw new Exception("Operands["+i+"] is null invalid");
			else
				this.operands[i]=(LogicFormulation) operands[i];
		}
	}
	

}
