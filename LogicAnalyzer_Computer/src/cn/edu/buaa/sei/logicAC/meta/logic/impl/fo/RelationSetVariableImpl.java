package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSet;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSetVariable;

public class RelationSetVariableImpl extends TypedVariableImpl implements RelationSetVariable{

	protected RelationSetVariableImpl(String name) throws Exception {
		super(name, RelationSet.class);
	}
	@Override
	public void assign(RelationSet val) throws Exception {
		super.assign(val);
	}
	public RelationSet read() throws Exception{
		return (RelationSet) super.read();
	}

}
