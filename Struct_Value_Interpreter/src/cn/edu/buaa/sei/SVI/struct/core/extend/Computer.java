package cn.edu.buaa.sei.SVI.struct.core.extend;

import cn.edu.buaa.sei.SVI.struct.core.Interpreter;

/**
 * <i>Computer</i> is the Interpreter which process <i>NumericStruct</i>.<br>
 * <i>Computer</i> could compute any NumericStruct and produce Number {Integer,Long,Double,Float ect...}
 * */
public interface Computer extends Interpreter{
	/**
	 * Register the NumericStruct element so to interpret it.<br>
	 * @exception Exception element==null
	 * */
	public void register(NumericStruct element) throws Exception;
	/**
	 * Compute the NumericStruct and return the Numeric Result.
	 * */
	public Number interpret() throws Exception;
}
