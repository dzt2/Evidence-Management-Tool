package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.Between;

public interface BetweenInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Between op) throws Exception;
}
