package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunctionTemplate;

public interface FunctionTemplateComputer extends Computer,IterationInterpreter{
	public Number interpret(NumericFunctionTemplate template) throws Exception;
}
