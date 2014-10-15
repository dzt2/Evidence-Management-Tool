package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Smaller;

public interface SmallerInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Smaller op) throws Exception;
}
