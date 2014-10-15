package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.group.Include;

public interface IncludeInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(Include op) throws Exception;
}
