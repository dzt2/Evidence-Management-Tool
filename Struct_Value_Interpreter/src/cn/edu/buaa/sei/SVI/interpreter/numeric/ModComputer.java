package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.Mod;

public interface ModComputer extends Computer,IterationInterpreter{
	public Number interpret(Mod op) throws Exception;
}
