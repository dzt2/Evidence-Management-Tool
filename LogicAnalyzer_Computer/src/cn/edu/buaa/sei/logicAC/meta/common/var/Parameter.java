package cn.edu.buaa.sei.logicAC.meta.common.var;

/**
 * Parameter is variable with in/out type.<br>
 * Parameter is often used in constructing function template.
 * */
public interface Parameter extends Variable{
	/**
	 * ParameterType present the type of data flow {in/out} 
	 * */
	public static enum ParameterType {
		/**
		 * IN present a variable used as input arguments in function template*/
		IN,
		/**
		 * OUT presents a variable used as output arguments in function template
		 * */
		OUT,
		/**
		 * INOUT presents a environment variable used in function while return the state to outside*/
		INOUT};
	
	/**
	 * Return the parameter type.
	 * */
	public ParameterType getParameterType();
	/**
	 * Set the parameter type of the parameter.
	 * 
	 * @throws Exception type==null */
	public void setParameterType(ParameterType type) throws Exception;
}
