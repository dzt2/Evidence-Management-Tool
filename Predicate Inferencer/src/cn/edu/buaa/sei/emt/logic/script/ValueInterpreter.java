package cn.edu.buaa.sei.emt.logic.script;

import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public interface ValueInterpreter {
	public Value interprete(ValueUnit unit);
}
