package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.Substraction;

public interface SubstractionComputer extends Computer,IterationInterpreter{
	public Number interpret(Substraction op) throws Exception;
}
