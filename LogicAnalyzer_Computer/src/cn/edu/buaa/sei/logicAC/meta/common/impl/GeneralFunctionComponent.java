package cn.edu.buaa.sei.logicAC.meta.common.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.ProtoFunction;
import cn.edu.buaa.sei.logicAC.meta.common.Parameter.ParameterType;

public class GeneralFunctionComponent implements ProtoFunction{
	
	public static final int MAX_PARM_SIZE = 64;
	
	String name;
	int len=0;
	Parameter[] parameters=new Parameter[MAX_PARM_SIZE];
	
	protected GeneralFunctionComponent(String name) throws Exception{
		if(name==null)throw new Exception("Null name is invalid to construct a function");
		
		this.name=name;
	}

	@Override
	public String getName() {return this.name;}

	@Override
	public List<Parameter> getInParamters() {
		List<Parameter> ps = new ArrayList<Parameter>();
		for(int i=0;i<len;i++)
			if(this.parameters[i].getType()==ParameterType.IN||this.parameters[i].getType()==ParameterType.INOUT)
				ps.add(this.parameters[i]);
		return ps;
	}

	@Override
	public List<Parameter> getOutParameters() {
		List<Parameter> ps = new ArrayList<Parameter>();
		for(int i=0;i<len;i++)
			if(this.parameters[i].getType()==ParameterType.OUT||this.parameters[i].getType()==ParameterType.INOUT)
				ps.add(this.parameters[i]);
		return ps;
	}

	@Override
	public List<Parameter> getAllParameters() {
		List<Parameter> ps = new ArrayList<Parameter>();
		for(int i=0;i<len;i++)
			ps.add(this.parameters[i]);
		return ps;
	}

	@Override
	public void addParameter(Parameter parameter) throws Exception {
		if(parameter==null)
			throw new Exception("Null parameter could not be applied in function");
		
		if(len>=MAX_PARM_SIZE)
			throw new Exception("Out of Limitaion Parameter Size: "+len);
		
		int i;
		for(i=0;i<len;i++){
			if(this.parameters[i]==parameter)return;
			if(this.parameters[i].getName().equals(parameter.getName()))
				throw new Exception("Name conflict at index ["+i+"]: "+parameter.getName());
		}
		
		this.parameters[len++]=parameter;
	}

	@Override
	public boolean containParameter(Parameter parameter) {
		if(parameter==null)return false;
		int i;
		for(i=0;i<this.len;i++){
			if(this.parameters[i]==parameter){
				return true;
			}
		}
		return false;
	}

	@Override
	public void removeParameter(Parameter parameter) throws Exception {
		if(parameter==null)
			throw new Exception("Null parameter must not be in parameter list of the function");
		
		int i;
		for(i=0;i<len;i++)
			if(this.parameters[i]==parameter)
				break;
		
		if(i>=len)
			throw new Exception("Parameter has not been defined in parameter list of the function");
		
		for(int j=i;j<len-1;j++)
			this.parameters[j]=this.parameters[j+1];
	}

	@Override
	public Parameter getParameter(String name) throws Exception {
		// TODO Auto-generated method stub
		if(name==null)
			throw new Exception("Null name point to no parameters");
		
		for(int i=0;i<len;i++)
			if(name.equals(this.parameters[i].getName()))
				return this.parameters[i];
		
		throw new Exception("No parameter with name: "+name);
	}

	@Override
	public Parameter getParameter(int i) throws Exception {
		if(i<0||i>=len)
			throw new Exception("Out of range [0--"+len+"): "+i);
		
		return this.parameters[i];
	}

	@Override
	public int size() {return this.len;}

}
