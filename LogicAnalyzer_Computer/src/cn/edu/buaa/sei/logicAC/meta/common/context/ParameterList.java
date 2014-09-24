package cn.edu.buaa.sei.logicAC.meta.common.context;

import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter;

public interface ParameterList extends Context{
	public int size();
	public Parameter getParameter(int i) throws Exception;
	public void addParameter(Parameter parameter) throws Exception;
	public void removeParameter(Parameter parameter) throws Exception;
	public boolean containParameter(Parameter parameter);
	
	public List<Parameter> getParameters();
	public List<Parameter> getInParameters();
	public List<Parameter> getOutParameters();
}
