package cn.edu.buaa.sei.SVI.core.program;

import cn.edu.buaa.sei.SVI.core.Struct;

public interface EndStatement extends Statement{
	/**
	 * Return the Struct whose result would be returned as a result.<br>
	 * If this is null, then the EndStatement just like "return;"
	 * */
	public Struct getEndStruct();
}
