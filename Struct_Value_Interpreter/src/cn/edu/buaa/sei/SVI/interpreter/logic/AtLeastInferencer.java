package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.AtLeast;

public interface AtLeastInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(AtLeast op) throws Exception;
}
