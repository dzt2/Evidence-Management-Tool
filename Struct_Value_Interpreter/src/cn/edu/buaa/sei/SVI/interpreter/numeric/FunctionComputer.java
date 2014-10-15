package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunction;

public interface FunctionComputer extends Computer,IterationInterpreter{
	public Number interpret(NumericFunction function) throws Exception;
}
