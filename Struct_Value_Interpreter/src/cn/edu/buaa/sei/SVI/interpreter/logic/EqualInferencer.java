package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Equal;

public interface EqualInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Equal op) throws Exception;
}
