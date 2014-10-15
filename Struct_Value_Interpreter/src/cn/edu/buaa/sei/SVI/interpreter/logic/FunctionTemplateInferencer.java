package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;

public interface FunctionTemplateInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(LogicFunctionTemplate template) throws Exception;
}
