package cn.edu.buaa.sei.emt.logic.io;

import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;

public interface LogicIO {
	public void write(LogicFormulation form);
	public LogicFormulation read();
}
