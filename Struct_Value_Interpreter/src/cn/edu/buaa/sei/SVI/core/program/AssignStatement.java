package cn.edu.buaa.sei.SVI.core.program;

import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.variable.Variable;

public interface AssignStatement extends Statement{
	/**
	 * Return the Variable which would be assigned.
	 * */
	public Variable getVariable();
	/**
	 * Return the <i>Struct</i> whose result would be assigned to the Variable.
	 * */
	public Struct getValueStruct();
}
