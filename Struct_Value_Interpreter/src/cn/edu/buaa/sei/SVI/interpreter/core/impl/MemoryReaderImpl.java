package cn.edu.buaa.sei.SVI.interpreter.core.impl;

import cn.edu.buaa.sei.SVI.interpreter.core.MemoryReader;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Bindable;

public class MemoryReaderImpl implements MemoryReader{

	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)
			throw new Exception("Reading unknown input");
		if(!(input instanceof Bindable))
			throw new Exception("Type Error in {MemoryReader}: "+input.getClass().getName());
		
		return this.interpret((Bindable)input);
	}

	@Override
	public Object interpret(Bindable var) throws Exception {
		if(var==null)
			throw new Exception("Reading unknown variable");
		return var.read();
	}
}
