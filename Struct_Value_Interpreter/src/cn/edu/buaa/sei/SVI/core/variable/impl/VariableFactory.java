package cn.edu.buaa.sei.SVI.core.variable.impl;

import cn.edu.buaa.sei.SVI.core.variable.FreeVariable;
import cn.edu.buaa.sei.SVI.core.variable.ReferenceVariable;
import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.BooleanVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.CharacterVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.DoubleVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.FloatVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.IntegerVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.ListVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.LongVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.MapVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.SetVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.StringVariable;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.BooleanVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.CharacterVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.DoubleVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.FloatVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.IntegerVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.ListVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.LongVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.MapVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.SetVariableImpl;
import cn.edu.buaa.sei.SVI.core.variable.impl.baseType.StringVariableImpl;

public class VariableFactory {
	public static final int BOOLEAN = 0;
	public static final int CHARACTER = 1;
	public static final int INTEGER = 2;
	public static final int LONG = 3;
	public static final int STRING = 4;
	public static final int FLOAT = 5;
	public static final int DOUBLE = 6;
	public static final int SET = 7;
	public static final int LIST = 8;
	public static final int MAP = 9;
	public static final int DYNAMIC = 10;
	public static final int REFER = 11;
	
	public static BooleanVariable createBoolean(String name) throws Exception{
		return new BooleanVariableImpl(name);
	}
	public static CharacterVariable createCharacter(String name) throws Exception{
		return new CharacterVariableImpl(name);
	}
	public static IntegerVariable createInteger(String name) throws Exception{
		return new IntegerVariableImpl(name);
	}
	public static LongVariable createLong(String name) throws Exception{
		return new LongVariableImpl(name);
	}
	public static FloatVariable createFloat(String name) throws Exception{
		return new FloatVariableImpl(name);
	}
	public static DoubleVariable createDouble(String name) throws Exception{
		return new DoubleVariableImpl(name);
	}
	public static StringVariable createString(String name) throws Exception{
		return new StringVariableImpl(name);
	}
	public static SetVariable createSet(String name) throws Exception{
		return new SetVariableImpl(name);
	}
	public static ListVariable createList(String name) throws Exception{
		return new ListVariableImpl(name);
	}
	public static MapVariable createMap(String name) throws Exception{
		return new MapVariableImpl(name);
	}
	public static FreeVariable createFreeVariable(String name) throws Exception{
		return new FreeVariableImpl(name);
	}
	public static ReferenceVariable createReference(String name) throws Exception{
		return new ReferenceVariableImpl(name,null);
	}
	
	public static Variable createVariable(String name,int type) throws Exception{
		switch(type){
		case BOOLEAN:return createBoolean(name);
		case INTEGER:return createInteger(name);
		case LONG:	 return createLong(name);
		case CHARACTER:return createCharacter(name);
		case FLOAT:	 return createFloat(name);
		case DOUBLE: return createDouble(name);
		case STRING: return createString(name);
		case LIST:	 return createList(name);
		case MAP:	 return createMap(name);
		case SET:	 return createSet(name);
		case DYNAMIC:return createFreeVariable(name);
		case REFER:	 return createReference(name);
		default: throw new Exception("Invalid Type ID: "+type+" {hope to be 0~11}");
		}
	}
}
