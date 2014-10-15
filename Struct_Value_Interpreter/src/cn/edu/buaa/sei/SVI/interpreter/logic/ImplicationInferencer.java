package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.Implication;

public interface ImplicationInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Implication op) throws Exception;
}
