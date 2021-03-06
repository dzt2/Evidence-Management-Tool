package cn.edu.buaa.sei.SVI.interpreter.logic.impl;

import cn.edu.buaa.sei.SVI.interpreter.core.RegisterMachine;
import cn.edu.buaa.sei.SVI.interpreter.logic.EqualInferencer;
import cn.edu.buaa.sei.SVI.interpreter.numeric.Computer;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.NumericStruct;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Equal;

public class EqualInferencerImpl implements EqualInferencer{

	@Override
	public Boolean interpret(LogicStruct input) throws Exception {
		if(input==null)
			throw new Exception("Null input is invalid");
		if(!(input instanceof Equal))
			throw new Exception("Equal required");
		
		Equal op = (Equal) input;
		return this.interpret(op);
	}
	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)
			throw new Exception("Null input is invalid");
		if(!(input instanceof Equal))
			throw new Exception("Equal required");
		
		Equal op = (Equal) input;
		return this.interpret(op);
	}

	@Override
	public Boolean interpret(Equal op) throws Exception {
		if(op==null)throw new Exception("Null operator is invalid");
		
		NumericStruct left = op.getLeftOperand();
		NumericStruct right = op.getRightOperand();
		
		if(left==null||right==null)
			throw new Exception("Structure Error: null operands");
		
		Computer lc = (Computer)RegisterMachine.getRegister().get(left);
		Computer rc = (Computer)RegisterMachine.getRegister().get(right);
		
		if(lc==null)
			throw new Exception("Left operand: "+left.getClass().getCanonicalName()+" has not be registered");
		if(rc==null)
			throw new Exception("Right operand: "+right.getClass().getCanonicalName()+" has not be registered");
		
		Number a = lc.interpret(left);
		Number b = rc.interpret(right);
		
		if(a==null||b==null)return null;
		
		//System.out.println("###Compare: ["+a+","+b+"]");
		int r = NumberComparator.compare(a, b);
		if(r==0)return true;
		else return false;
	}

}
