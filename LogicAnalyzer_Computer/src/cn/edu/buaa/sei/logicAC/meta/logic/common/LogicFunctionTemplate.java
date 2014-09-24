package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.context.NormativeParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.function.FunctionTemplate;

/**
 * FunctionTemplate is in <b>general computation environment</b>,<br> 
 * while LogicFunctionTemplate is in <b>logic environment</b>.<br>
 * 1) FunctionTemplate: 	 <b>[o1...] func_name (x1...)</b> <br>
 * 2) LogicFunctionTemplate: <b>[bool_o] func_name (x1...)</b>
 * */
public interface LogicFunctionTemplate extends FunctionTemplate{
	/**
	 * Set the parameter list of function.
	 * @exception Exception plist==null
	 * */
	public void setParameters(NormativeParameterList plist) throws Exception;
}
