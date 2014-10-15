package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.ESmaller;

public interface ESmallerInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(ESmaller op) throws Exception;
}
