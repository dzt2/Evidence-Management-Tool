package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.ListVariable;

public class ListVariableImpl extends TypedVariableImpl implements ListVariable{

	protected ListVariableImpl(String name) throws Exception {super(name, List.class);}
	@Override
	public void assign(List<?> val) throws Exception {super.assign(val);}
	@Override
	public List<?> read() throws Exception{return (List<?>) super.read();}
}
