package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.Disjunction;

public interface DisjunctionInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Disjunction op) throws Exception;
}
