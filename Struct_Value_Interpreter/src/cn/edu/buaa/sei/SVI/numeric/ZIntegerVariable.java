package cn.edu.buaa.sei.SVI.numeric;

/**
 * Z is the set of Integers.
 * Integer is presented as {Long} and could be < 0
 * */
public interface ZIntegerVariable extends NumericVariable{
	/**
	 * Return the value to which the bindable refers.
	 * @exception Exception {Referencer} null referring variable.
	 * */
	public Long read() throws Exception;
	/**
	 * Write the value to the bindable space.
	 * */
	public void assign(Long val) throws Exception;
}
