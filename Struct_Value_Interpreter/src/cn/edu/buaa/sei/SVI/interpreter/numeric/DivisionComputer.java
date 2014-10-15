package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.Division;

public interface DivisionComputer extends Computer,IterationInterpreter{
	public Number interpret(Division op) throws Exception;
}
