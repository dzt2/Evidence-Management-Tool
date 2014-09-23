package cn.edu.buaa.sei.logicAC.meta.common.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.logicAC.meta.common.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.ProtoFunction;
import cn.edu.buaa.sei.logicAC.meta.common.Parameter.ParameterType;

/**
 * GeneralFunctionComponent as a function component, manage the parameters in it and has no meaning to be computed.<br>
 * However, this class is not abstract so to used as a component that manager parameter list. Good for package design pattern.
 * */
public class GeneralFunctionComponent implements ProtoFunction{
	
	/**
	 * The largest length of parameters: any attempt to add parameters more than the limitation would cause exception.
	 * */
	public static final int MAX_PARM_SIZE = 64;
	
	/**
	 * Function Name
	 * */
	String name;
	/**
	 * Current Length of Parameter
	 * */
	int len=0;
	/**
	 * Parameter List with limitation size: MAX_PARM_SIZE
	 * */
	Parameter[] parameters=new Parameter[MAX_PARM_SIZE];
	
	/**
	 * GeneralFunctionComponent can be constructed, not abstract.<br>
	 * The name could not be null or it will cause an exception.
	 * @exception Exception
	 * */
	public GeneralFunctionComponent(String name) throws Exception{
		if(name==null)throw new Exception("Null name is invalid to construct a function");
		
		this.name=name;
	}

	/**
	 * Return the function name.
	 * @return this.name
	 * */
	@Override
	public String getName() {return this.name;}

	/**
	 * Return all the input parameters in a List. For each time, it would generate a new list.<br>
	 * Note that not to call this function too much in system, or it would waste too much resource.
	 * @return new ArrayList
	 * */
	@Override
	public List<Parameter> getInParamters() {
		List<Parameter> ps = new ArrayList<Parameter>();
		for(int i=0;i<len;i++)
			if(this.parameters[i].getType()==ParameterType.IN||this.parameters[i].getType()==ParameterType.INOUT)
				ps.add(this.parameters[i]);
		return ps;
	}

	/**
	 * Return all the output parameters in a List. For each time, it would generate a new list. <br>
	 * Note that not to call this function too much in system, so to reduce the time/space cost.
	 * @return new ArrayList
	 * */
	@Override
	public List<Parameter> getOutParameters() {
		List<Parameter> ps = new ArrayList<Parameter>();
		for(int i=0;i<len;i++)
			if(this.parameters[i].getType()==ParameterType.OUT||this.parameters[i].getType()==ParameterType.INOUT)
				ps.add(this.parameters[i]);
		return ps;
	}

	/**
	 * Return all the parameters (in+out) in a List. For each time, it would generate a new list. <br>
	 * Note that not to call this function too much in system, so to reduce the time/space cost.
	 * @return new ArrayList
	 * */
	@Override
	public List<Parameter> getAllParameters() {
		List<Parameter> ps = new ArrayList<Parameter>();
		for(int i=0;i<len;i++)
			ps.add(this.parameters[i]);
		return ps;
	}

	/**
	 * Add new parameter into the parameter list.<br>
	 * @exception - parameter is null
	 * @exception - currently size of parameter list is out of limitation. [MAX_PARM_SIZE]
	 * @exception - exist parm in parameter list: parm.name == parameter.name && parm!=parameter
	 * @return parameter in parameter list
	 * @author dzt
	 * */
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

	/**
	 * Return whether the parameter has been in the parameter list.<br>
	 * @return false: parameter == null
	 * */
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

	/**
	 * Remove the parameter from the parameter list.
	 * @exception Exception parameter is not in parameter list.
	 * @exception Exception parameter is null.
	 * */
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

	/**
	 * Return the parameter with the specified name
	 * @exception Exception name is null
	 * @exception Exception no parameter in list is specified with the name.
	 * */
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

	/**
	 * Return the parameter with the index location
	 * @exception Exception i out of range [0,len)
	 * */
	@Override
	public Parameter getParameter(int i) throws Exception {
		if(i<0||i>=len)
			throw new Exception("Out of range [0--"+len+"): "+i);
		
		return this.parameters[i];
	}

	/**
	 * Return current size of parameter list.
	 * @return this.len
	 * */
	@Override
	public int size() {return this.len;}

}
