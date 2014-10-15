package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.AtMost;

public interface AtMostInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(AtMost op) throws Exception;
}
