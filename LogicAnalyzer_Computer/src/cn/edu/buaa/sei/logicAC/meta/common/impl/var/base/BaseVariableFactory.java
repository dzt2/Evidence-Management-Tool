package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.FreeVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class BaseVariableFactory {
	public static final int BOOLEAN = 0;
	public static final int INTEGER = 1;
	public static final int LONG = 2;
	public static final int CHARACTER = 3;
	public static final int FLOAT = 4;
	public static final int DOUBLE = 5;
	public static final int STRING = 6;
	public static final int LIST = 7;
	public static final int SET = 8;
	public static final int MAP = 9;
	public static final int DATE = 10;
	public static final int DYNAMIC = 11;
	
	public static Variable createVariable(String name,int type) throws Exception{
		if(name==null)
			throw new NullPointerException("Null name cannot be used for constructing variable");
		switch(type){
		case BOOLEAN:return new BooleanVariableImpl(name);
		case INTEGER:return new IntegerVariableImpl(name);
		case LONG: 	 return new LongVariableImpl(name);
		case CHARACTER:return new CharacterVariableImpl(name);
		case FLOAT:	 return new FloatVariableImpl(name);
		case DOUBLE: return new DoubleVariableImpl(name);
		case STRING: return new StringVariableImpl(name);
		case LIST:	 return new ListVariableImpl(name);
		case SET: 	 return new SetVariableImpl(name);
		case MAP:	 return new MapVariableImpl(name);
		case DATE: 	 return new DateVariableImpl(name);
		case DYNAMIC:return new FreeVariableImpl(name);
		default: throw new Exception("Unknown type code: "+type);
		}
	}
}
