package cn.edu.buaa.sei.logicAC.meta.common.api;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

/**
 * ComputableAPI provides programmers an interface to define function themselves.<br>
 * Through re-writing <b>body()</b>, it is easy to implement the required function of a specific class of computable.<br>
 * The input arguments could be get through this.template.parameterList and output can be set through that.
 * */
public interface ComputableAPI extends Computable{
	public void body() throws Exception;
}
