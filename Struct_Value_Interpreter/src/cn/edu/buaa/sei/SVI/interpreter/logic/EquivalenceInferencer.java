package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.Equivalence;

public interface EquivalenceInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Equivalence op) throws Exception;
}
