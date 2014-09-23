package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.FreeVariable;

/**
 * DynamicVariable is the implementation of FreeVaraible Interface, and is not abstract (could be directly constructed).
 * */
public class DynamicVariable extends VariableImpl implements FreeVariable{

	/**
	 * DynamicVariable can be constructed by user to create pointers to any value (object) in memory space.
	 * */
	public DynamicVariable(String name) throws Exception {
		super(name);
	}

}
