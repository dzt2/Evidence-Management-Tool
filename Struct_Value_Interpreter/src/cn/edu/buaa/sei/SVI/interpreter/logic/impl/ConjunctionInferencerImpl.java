package cn.edu.buaa.sei.SVI.interpreter.logic.impl;

import cn.edu.buaa.sei.SVI.interpreter.core.impl.IterationInterpreterImpl;
import cn.edu.buaa.sei.SVI.interpreter.core.impl.SelecterRunner;
import cn.edu.buaa.sei.SVI.interpreter.logic.ConjunctionInferencer;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.logic.Conjunction;

public class ConjunctionInferencerImpl extends IterationInterpreterImpl implements ConjunctionInferencer{

	@Override
	public Boolean interpret(LogicStruct input) throws Exception {
		if(input==null)
			throw new Exception("Null input is invalid");
		if(!(input instanceof Conjunction))
			throw new Exception("Type Error: "+input.getClass().getCanonicalName()+" {Conjunction required}");
		
		Conjunction op = (Conjunction) input;
		return this.interpret(op);
	}

	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)
			throw new Exception("Null input is invalid");
		if(!(input instanceof Conjunction))
			throw new Exception("Type Error: "+input.getClass().getCanonicalName()+" {Conjunction required}");
		
		Conjunction op = (Conjunction) input;
		return this.interpret(op);
	}

	@Override
	public Boolean interpret(Conjunction op) throws Exception {
		if(op==null)
			throw new Exception("Null input is invalid");
		
		LogicStruct[] operands = op.getOperands();
		
		if(operands==null)
			throw new Exception("Invalid Structrue: null operands");
		
		SelecterRunner[] runners = new SelecterRunner[operands.length];
		Thread[] threads = new Thread[operands.length];
		for(int i=0;i<operands.length;i++){
			runners[i]=new SelecterRunner(operands[i],this);
			threads[i]=new Thread(runners[i]);
			threads[i].start();
		}
		
		boolean containNull = false;
		for(int i=0;i<threads.length;i++){
			threads[i].join();
			if(runners[i].getException()!=null){
				throw runners[i].getException();
			}
			
			Boolean result = (Boolean) runners[i].getResult();
			
			if(result==null)containNull=true;
			else if(result==false)return false;
		}
		
		if(containNull)
			return null;
		else return true;
	}
	
	

}
