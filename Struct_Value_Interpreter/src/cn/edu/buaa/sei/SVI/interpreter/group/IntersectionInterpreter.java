package cn.edu.buaa.sei.SVI.interpreter.group;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.group.Group;
import cn.edu.buaa.sei.SVI.struct.group.Intersection;

public interface IntersectionInterpreter extends GroupInterpreter,IterationInterpreter{
	public Group interpret(Intersection op) throws Exception;
}
