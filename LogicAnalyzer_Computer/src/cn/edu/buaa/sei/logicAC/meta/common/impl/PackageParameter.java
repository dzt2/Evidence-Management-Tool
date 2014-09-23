package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.ComputedContext;
import cn.edu.buaa.sei.logicAC.meta.common.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.Variable;

/**
 * PackageParameter package a variable in its content so that other characteristics of variables (typed/free) 
 * could be mitigated.
 * PackageParameter could be directly used (not abstract).
 * */
public class PackageParameter implements Parameter{
	/**
	 * Parameter type present {IN, OUT, INOUT}
	 * */
	ParameterType type = ParameterType.IN;
	/**
	 * Packaged Variable to provide other information in parameter
	 * */
	Variable variable;
	
	/**
	 * Construct a parameter which package the variable as content.
	 * */
	public PackageParameter(Variable variable) throws Exception{
		if(variable==null)throw new Exception("Packaging null variable is invalid");
		this.variable=variable;
	}

	/**
	 * Return the name of parameter (its packaged variable's name)
	 * @return this.variable.getName()
	 * */
	@Override
	public String getName() {return this.variable.getName();}

	/**
	 * Return the object that is referred by parameter (by the variable packaged in this parameter)
	 * @return this.variable.read()
	 * */
	@Override
	public Object read() throws Exception {return this.variable.read();}

	/**
	 * Set the value of the parameter (the variable packaged in the parameter)
	 * */
	@Override
	public void assign(Object val) throws Exception {this.variable.assign(val);}

	/**
	 * Return whether the parameter could be computable. As we know, any bindable could be computed since 
	 * the result is the value referred by the bindable.
	 * @return this.variable.isComputable()
	 * */
	@Override
	public boolean isComputable() {return this.variable.isComputable();}

	/**
	 * Interpret the parameter with context, it is the same to interpret the variable packaged in this parameter
	 * @return this.variable.interpret(context)
	 * */
	@Override
	public boolean interpret(ComputedContext context) {return this.variable.interpret(context);}

	/**
	 * Return the parameter type as a result.
	 * @return this.type
	 * */
	@Override
	public ParameterType getType() {return this.type;}

	/**
	 * Set the parameter type of this parameter
	 * */
	@Override
	public void setType(ParameterType type) {this.type=type;}
	
	

}
