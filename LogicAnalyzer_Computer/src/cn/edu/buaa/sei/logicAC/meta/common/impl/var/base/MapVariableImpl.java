package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import java.util.Map;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.MapVariable;

public class MapVariableImpl extends TypedVariableImpl implements MapVariable{

	protected MapVariableImpl(String name) throws Exception {super(name, Map.class);}
	@Override
	public void assign(Map<?, ?> val) throws Exception {super.assign(val);}
	@Override
	public Map<?,?> read() throws Exception{return (Map<?, ?>) super.read();}
}
