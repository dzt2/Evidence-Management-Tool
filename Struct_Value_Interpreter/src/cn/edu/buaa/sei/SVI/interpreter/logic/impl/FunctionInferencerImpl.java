package cn.edu.buaa.sei.SVI.interpreter.logic.impl;

import cn.edu.buaa.sei.SVI.interpreter.logic.FunctionInferencer;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionBody;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionBodyAPI;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.LogicVariable;

public class FunctionInferencerImpl implements FunctionInferencer{

	@Override
	public Boolean interpret(LogicStruct input) throws Exception {
		if(input==null)throw new Exception("Null input is invalid");
		if(!(input instanceof LogicFunction))throw new Exception("LogicFunction required");
		
		LogicFunction function = (LogicFunction) input;
		return this.interpret(function);
	}

	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)throw new Exception("Null input is invalid");
		if(!(input instanceof LogicFunction))throw new Exception("LogicFunction required");
		
		LogicFunction function = (LogicFunction) input;
		return this.interpret(function);
	}

	@Override
	public Boolean interpret(LogicFunction function) throws Exception {
		if(function==null)
			throw new Exception("Null function is invalid");
		
		LogicFunctionTemplate template = function.getTemplate();
		if(template==null)
			throw new Exception("Structural Error: null template");
		
		Inferencer inferencer = null;
		try{
			inferencer = (Inferencer) register.get(template);
		}
		catch(Exception ex){
			inferencer = null;
		}
		
		if(inferencer!=null){
			return inferencer.interpret(template);
		}
		else{
			FunctionBody body = function.getBody();
			if(body==null)
				throw new Exception("Not a native function: Body required");
			
			if(body instanceof FunctionBodyAPI){
				((FunctionBodyAPI) body).execute();
			}
			else return null;
			
			LogicVariable out = template.getOutput();
			return out.read();
		}
	}

}
