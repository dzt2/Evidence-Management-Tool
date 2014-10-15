package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.group.GroupEqual;

public interface GroupEqualInferencer extends Inferencer,IterationInterpreter{
	public Boolean interpret(GroupEqual op) throws Exception;
}
