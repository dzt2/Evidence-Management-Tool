package cn.edu.buaa.sei.SVI.interpreter.logic.impl;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.impl.IterationInterpreterImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.ExpressionInferencer;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicOperator;

public class ExpressionInferencerImpl extends IterationInterpreterImpl implements ExpressionInferencer{

	@Override
	public Boolean interpret(LogicStruct input) throws Exception {
		if(input==null)
			throw new Exception("Null input is invalid");
		if(!(input instanceof LogicExpression))
			throw new Exception("Type Errors: "+input.getClass().getCanonicalName());
		
		LogicExpression expr = (LogicExpression) input;
		return this.interpret(expr);
	}

	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)
			throw new Exception("Null input is invalid");
		if(!(input instanceof LogicExpression))
			throw new Exception("Type Errors: "+input.getClass().getCanonicalName());
		
		LogicExpression expr = (LogicExpression) input;
		return this.interpret(expr);
	}

	@Override
	public Boolean interpret(LogicExpression expr) throws Exception {
		if(expr==null)
			throw new Exception("Null input is invalid");
		
		final LogicOperator op = expr.getOperator();
		if(op==null)
			throw new Exception("Structure Error: Null Operator");
		
		OperatorRunner runner = new OperatorRunner(op,this);
		Thread t = new Thread(runner);
		
		t.start();t.join();
		
		if(runner.ex!=null)
			throw runner.ex;
		
		return runner.result;
	}
	
	static class OperatorRunner implements Runnable{
		LogicOperator op;
		Boolean result=null;
		IterationInterpreter parent;
		Exception ex=null;
		
		OperatorRunner(LogicOperator op,IterationInterpreter parent){
			this.op=op;
			this.parent=parent;
		}

		@Override
		public void run() {
			try {
				Inferencer inferencer = (Inferencer) this.parent.getRegisterMachine().get(op);
				
				if(inferencer==null)
					throw new Exception("No-binded with any interpreter: {"+this.op.hashCode()+"}");
				
				this.result=inferencer.interpret(op);
			} catch (Exception e) {
				ex=e;
				return;
			}
		}
	}

}
