package cn.edu.buaa.sei.logicAC.meta.common.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface CharacterVariable extends TypedVariable{
	public Character read() throws Exception;
	public void assign(Character val) throws Exception;
}
