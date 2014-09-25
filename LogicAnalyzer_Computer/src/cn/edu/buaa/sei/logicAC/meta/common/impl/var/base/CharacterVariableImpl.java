package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.CharacterVariable;

public class CharacterVariableImpl extends TypedVariableImpl implements CharacterVariable{

	protected CharacterVariableImpl(String name) throws Exception {super(name, Character.class);}

	@Override
	public void assign(Character val) throws Exception {super.assign(val);}
	@Override
	public Character read() throws Exception{return (Character) super.read();}

}
