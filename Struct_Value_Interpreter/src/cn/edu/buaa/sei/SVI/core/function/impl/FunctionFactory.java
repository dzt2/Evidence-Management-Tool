package cn.edu.buaa.sei.SVI.core.function.impl;

import cn.edu.buaa.sei.SVI.core.function.Context;
import cn.edu.buaa.sei.SVI.core.function.UFunctionBody;
import cn.edu.buaa.sei.SVI.core.program.Program;

public class FunctionFactory {
	public static Context createContext(Context parent) throws Exception{
		return new ContextImpl(parent);
	}
	public static UFunctionBody createFunctionBody(Program program) throws Exception{
		return new UFunctionBodyImpl(program);
	}
}
