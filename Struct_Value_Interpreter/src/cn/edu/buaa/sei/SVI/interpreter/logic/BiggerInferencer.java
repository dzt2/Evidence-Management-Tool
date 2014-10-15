package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Bigger;

public interface BiggerInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Bigger op) throws Exception;
}
