package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.Conjunction;

public interface ConjunctionInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Conjunction op) throws Exception;
}
