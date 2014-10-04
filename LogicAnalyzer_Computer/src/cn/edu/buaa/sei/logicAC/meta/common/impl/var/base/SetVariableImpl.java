package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.SetVariable;

public class SetVariableImpl extends TypedVariableImpl implements SetVariable{

	protected SetVariableImpl(String name) throws Exception {super(name, Set.class);}

	@Override
	public void assign(Set<Object> val) throws Exception {super.assign(val);}
	@SuppressWarnings("unchecked")
	public Set<Object> read() throws Exception{return (Set<Object>) super.read();}
}
