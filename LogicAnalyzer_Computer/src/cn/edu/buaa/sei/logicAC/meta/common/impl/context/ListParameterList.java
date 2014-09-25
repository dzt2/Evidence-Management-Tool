package cn.edu.buaa.sei.logicAC.meta.common.impl.context;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.context.GeneralParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.PackagedContext;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter.ParameterType;

public class ListParameterList extends PackagedContext implements GeneralParameterList{
	List<Parameter> list = new ArrayList<Parameter>();

	protected ListParameterList(Context context) throws Exception {super(context);}

	@Override
	public int size() {return this.list.size();}

	@Override
	public Parameter getParameter(int i) throws Exception {
		if(i<0||i>=this.list.size())
			throw new Exception("Out of range: "+i+" hope to be in [0,"+this.list.size()+")");
		return this.list.get(i);
	}

	@Override
	public void addParameter(Parameter parameter) throws Exception {
		if(parameter==null)
			throw new NullPointerException("Null parameter is invalid in list");
		if(this.list.contains(parameter))return;
		this.list.add(parameter);
	}

	@Override
	public void removeParameter(Parameter parameter) throws Exception {
		if(parameter==null)
			throw new NullPointerException("Null parameter is invalid in list");
		if(!this.list.contains(parameter))
			throw new Exception("Parameter is not in the list");
		this.list.remove(parameter);
	}

	@Override
	public boolean containParameter(Parameter parameter) {
		if(parameter==null)return false;
		return this.list.contains(parameter);
	}

	@Override
	public List<Parameter> getParameters() {return this.list;}

	@Override
	public List<Parameter> getInParameters() {
		List<Parameter> ilist = new ArrayList<Parameter>();
		for(int i=0;i<this.list.size();i++){
			Parameter par = this.list.get(i);
			if(par.getParameterType()==ParameterType.IN||par.getParameterType()==ParameterType.INOUT)
				ilist.add(par);
		}
		return ilist;
	}

	@Override
	public List<Parameter> getOutParameters() {
		List<Parameter> olist = new ArrayList<Parameter>();
		for(int i=0;i<this.list.size();i++){
			Parameter par = this.list.get(i);
			if(par.getParameterType()==ParameterType.OUT||par.getParameterType()==ParameterType.INOUT)
				olist.add(par);
		}
		return olist;
	}

}
