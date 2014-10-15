package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.Addition;

public interface AdditionComputer extends Computer,IterationInterpreter{
	public Number interpret(Addition op) throws Exception;
}
