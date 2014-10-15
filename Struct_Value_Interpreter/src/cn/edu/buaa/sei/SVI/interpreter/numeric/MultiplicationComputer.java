package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.Multiplication;

public interface MultiplicationComputer extends Computer,IterationInterpreter{
	public Number interpret(Multiplication op) throws Exception;
}
