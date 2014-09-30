package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.FreeVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.impl.var.ParameterImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter.ParameterType;
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
	
	public static Parameter createParameter(String name,int type,ParameterType ptype) throws Exception{
		switch(type){
		case BOOLEAN:return new ParameterImpl(new BooleanVariableImpl(name),ptype);
		case INTEGER:return new ParameterImpl(new IntegerVariableImpl(name),ptype);
		case LONG: 	 return new ParameterImpl(new LongVariableImpl(name),ptype);
		case CHARACTER:return new ParameterImpl(new CharacterVariableImpl(name),ptype);
		case FLOAT:	 return new ParameterImpl(new FloatVariableImpl(name),ptype);
		case DOUBLE: return new ParameterImpl(new DoubleVariableImpl(name),ptype);
		case STRING: return new ParameterImpl(new StringVariableImpl(name),ptype);
		case LIST:	 return new ParameterImpl(new ListVariableImpl(name),ptype);
		case SET: 	 return new ParameterImpl(new SetVariableImpl(name),ptype);
		case MAP:	 return new ParameterImpl(new MapVariableImpl(name),ptype);
		case DATE: 	 return new ParameterImpl(new DateVariableImpl(name),ptype);
		case DYNAMIC:return new ParameterImpl(new FreeVariableImpl(name),ptype);
		default: throw new Exception("Unknown type code: "+type);
		}
	}
}
