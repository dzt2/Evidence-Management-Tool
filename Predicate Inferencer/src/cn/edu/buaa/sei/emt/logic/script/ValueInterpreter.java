package cn.edu.buaa.sei.emt.logic.script;

import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public interface ValueInterpreter {
	public static enum ValueType {Bool,Object,Relation,Set,RelationSet};
	
	public ValueType getType(ValueUnit unit);
	public Boolean isValid(ValueUnit unit);
	public Value interprete(ValueUnit unit);
}
