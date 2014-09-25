package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.LongVariable;

public class LongVariableImpl extends TypedVariableImpl implements LongVariable{

	protected LongVariableImpl(String name) throws Exception {super(name, Long.class);}
	@Override
	public void assign(Long val) throws Exception {super.assign(val);}
	@Override
	public Long read() throws Exception{return (Long) super.read();}
}
