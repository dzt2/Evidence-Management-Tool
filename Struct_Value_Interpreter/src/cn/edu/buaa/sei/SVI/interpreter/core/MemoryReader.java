package cn.edu.buaa.sei.SVI.interpreter.core;

import cn.edu.buaa.sei.SVI.struct.core.variable.Bindable;

public interface MemoryReader extends AtomicInterpreter{
	public Object interpret(Bindable var) throws Exception;
}
