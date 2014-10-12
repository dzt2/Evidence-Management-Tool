package cn.edu.buaa.sei.SVI.group;

import cn.edu.buaa.sei.SVI.core.Interpreter;
import cn.edu.buaa.sei.SVI.core.extend.GroupStruct;

public interface GroupInterpreter extends Interpreter{
	/**
	 * Register the struct element so to interpret it.<br>
	 * @exception Exception element==null
	 * */
	public void register(GroupStruct element) throws Exception;
	/**
	 * Inference the LogicStruct so to get its Boolean results.
	 * @exception Exception element cannot be computed by many reasons...
	 * */
	public Group interpret() throws Exception;
}
