package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.ComputableFunction;
import cn.edu.buaa.sei.logicAC.meta.common.ComputedContext;

/**
 * ComputableFunctionComponent is the common component class of computable function in system.<br>
 * It manage another attribute "context" in its contents so to be used as component. <br>
 * So this class is not abstract and can be instanced.
 * */
public class ComputableFunctionComponent extends GeneralFunctionComponent implements ComputableFunction{
	/**
	 * The computed context of the function
	 * */
	ComputedContext context;
	
	/**
	 * Construct the function by name and context.
	 * @exception Exception name is null
	 * @exception Exception context is null
	 * */
	protected ComputableFunctionComponent(String name,ComputedContext context) throws Exception {
		super(name);
		if(context==null)throw new Exception("Null context is invalid to construct function");
		
		this.context=context;
	}

	/**
	 * Config the context of the computable function component.
	 * @return false - context is null
	 * */
	@Override
	public boolean interpret(ComputedContext context) {
		if(context==null)return false;
		this.context=context;
		return true;
	}

}
