package cn.edu.buaa.sei.emt.logic.io;

import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public interface ValueInterpreter {
	public enum ValueType {LObject,LRelation,LSet,LRelationSet};
	
	public Boolean isValid(String text) throws Exception;
	public ValueType getType(String text) throws Exception;
	public Value interprete(String text) throws Exception;
	
	public String reInterprete(Value val) throws Exception;
}
