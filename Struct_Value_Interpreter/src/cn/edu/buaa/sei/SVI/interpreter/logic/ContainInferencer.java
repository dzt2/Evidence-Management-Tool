package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.group.Contain;

public interface ContainInferencer extends Inferencer,IterationInterpreter {
	public Boolean interpret(Contain op) throws Exception;
}
