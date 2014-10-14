package cn.edu.buaa.sei.SVI.core;

/**
 * Engine is a machine to manage the binding between Struct Type and their Interpreter.
 * */
public interface Engine {
	/**
	 * Bind a new Interpreter for a given class of Struct so to dynamically 
	 * decided how to interpret some Struct.<br>
	 * If the type has been binded with an old interpreter, this new one would replace it.
	 * @exception Exception type==null||interpreter==null
	 * */
	public void bind(Class<Struct> type,Interpreter interpreter) throws Exception;
	/**
	 * Return the interpreter for computing Struct from a given type.<br>
	 * @exception Exception type==null
	 * @exception Exception type has not been registered with any interpreter.
	 * */
	public Interpreter getIntepreter(Class<Struct> type) throws Exception;
	/**
	 * Checking whether a type has been binded with any Interpreter.
	 * */
	public boolean isBinded(Class<Struct> type);
	/**
	 * Release the interpreter from a given type Struct.
	 * @exception Exception type==null
	 * @exception !this.isRegister(type)
	 * */
	public void logoff(Class<Struct> type) throws Exception;
}
