package cn.edu.buaa.sei.SVI.interpreter.group;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.group.Group;
import cn.edu.buaa.sei.SVI.struct.group.GroupExpression;

public interface GroupExpressionInterpreter extends GroupInterpreter,IterationInterpreter{
	public Group interpret(GroupExpression expr) throws Exception;
}
