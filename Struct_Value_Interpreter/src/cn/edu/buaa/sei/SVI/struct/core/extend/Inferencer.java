package cn.edu.buaa.sei.SVI.struct.core.extend;

import cn.edu.buaa.sei.SVI.struct.core.Interpreter;

/**
 * <i>Inferencer</i> is the Interpreter which process and compute LogicStruct's result.
 * */
public interface Inferencer extends Interpreter{
	/**
	 * Register the struct element so to interpret it.<br>
	 * @exception Exception element==null
	 * */
	public void register(LogicStruct element) throws Exception;
	/**
	 * Inference the LogicStruct so to get its Boolean results.
	 * @exception Exception element cannot be computed by many reasons...
	 * */
	public Boolean interpret() throws Exception;
}
