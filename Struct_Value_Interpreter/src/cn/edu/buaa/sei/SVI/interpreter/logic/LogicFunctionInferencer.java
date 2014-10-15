package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;

public interface LogicFunctionInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(LogicFunction function) throws Exception;
}
