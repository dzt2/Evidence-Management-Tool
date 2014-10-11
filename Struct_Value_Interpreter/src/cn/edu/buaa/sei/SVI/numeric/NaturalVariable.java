package cn.edu.buaa.sei.SVI.numeric;

/**
 * Natural Number is Integer {using Long to present} that is bigger or equal to 0.
 * */
public interface NaturalVariable extends NumericVariable{
	/**
	 * Return the value to which the bindable refers.
	 * @exception Exception {Referencer} null referring variable.
	 * */
	public Long read() throws Exception;
	/**
	 * Write the value to the bindable space.
	 * @exception Exception val<0
	 * */
	public void assign(Long val) throws Exception;
}
