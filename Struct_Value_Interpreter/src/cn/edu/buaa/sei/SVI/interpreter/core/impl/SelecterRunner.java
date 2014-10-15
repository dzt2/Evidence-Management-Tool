package cn.edu.buaa.sei.SVI.interpreter.core.impl;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class SelecterRunner implements Runnable{
	IterationInterpreter parent;
	Struct input;
	Object result;
	Exception ex;
	
	public SelecterRunner(Struct input,IterationInterpreter parent)throws Exception{
		if(input==null||parent==null)
			throw new Exception("Input|Parent could not be null.");
		
		this.parent=parent;this.input=input;
	}

	@Override
	public void run() {
		try {
			Interpreter interpreter = this.parent.getRegisterMachine().get(input);
			
			if(interpreter==null)
				throw new Exception("No-binded with any interpreter with type "+this.input.getClass().getCanonicalName()
						+"{"+this.input.hashCode()+"}");
			
			this.result=interpreter.interpret(input);
		} catch (Exception e) {
			ex=e;
			return;
		}
	}
	
	public Object getResult(){return this.result;}
	public Exception getException(){return this.ex;}
	
}
