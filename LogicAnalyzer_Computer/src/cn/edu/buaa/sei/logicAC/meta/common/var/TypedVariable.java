package cn.edu.buaa.sei.logicAC.meta.common.var;

/**
 * TypedVariable is variable that binds to specified type, such as a variable definition with type.<br>
 * base{BooleanVariable, IntegerVariable, LongVariable, FloatVariable, DoubleVariable, 
 * DateVariable, StringVariable, 
 * CharacterVariable, ListVariable, ArrayVariable, MapVariable, SetVariable}
 * */
public interface TypedVariable extends Variable{
	/**
	 * Return the java type specified by this variable.
	 * */
	public Class<?> getType();
	/**
	 * Checking whether a specified value is compatible with the variable type.<br>
	 * 1) If not compatible, the value would cause an exception when assign(val) to this variable.
	 * */
	public boolean isCompatible(Object val);
}
