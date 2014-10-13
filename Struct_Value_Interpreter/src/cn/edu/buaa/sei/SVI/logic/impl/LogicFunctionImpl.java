package cn.edu.buaa.sei.SVI.logic.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.function.Context;
import cn.edu.buaa.sei.SVI.core.function.FunctionBody;
import cn.edu.buaa.sei.SVI.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.logic.LogicFunctionTemplate;

public class LogicFunctionImpl implements LogicFunction{
	CompositeStruct container;
	LogicFunctionTemplate template;
	FunctionBody body;
	Context context;
	
	/**
	 * For any function, its template and container must not be null.<br>
	 * However, a function could have null <b>FunctionBody</b> if it is a Native Method.<br>
	 * Except for that, context should not be null, at least the global context, <b>even though we accept such situation</b>.<br>
	 * Children: [template,{context},{body}]
	 * */
	public LogicFunctionImpl(LogicFunctionTemplate template,FunctionBody body,
			Context context,CompositeStruct container) throws Exception{
		if(template==null)
			throw new Exception("Null Template is invalid for function integrity");
		if(container==null)
			throw new Exception("Container should not be Null");
		
		this.template=template;
		this.body=body;
		this.context=context;
		this.container=container;
		
		this.container.addChildStruct(template);
		if(this.context!=null)this.container.addChildStruct(context);
		if(this.body!=null)this.container.addChildStruct(body);
		
		this.template.setFunction(this);
		if(this.body!=null)this.body.setFunction(this);
	}

	@Override
	public Struct[] getChildrenStructs() {
		return this.container.getChildrenStructs();
	}

	@Override
	public void addChildStruct(Struct child) throws Exception {
		this.container.addChildStruct(child);
	}

	@Override
	public void removeChildStruct(Struct child) throws Exception {
		this.container.removeChildStruct(child);
	}

	@Override
	public boolean containChildStruct(Struct child) {
		return this.container.containChildStruct(child);
	}

	@Override
	public int getChildrenStructSize() {
		return this.container.getChildrenStructSize();
	}

	@Override
	public Context getContext() {
		return this.context;
	}

	@Override
	public FunctionBody getBody() {
		return this.body;
	}

	@Override
	public LogicFunctionTemplate getTemplate() {
		return this.template;
	}
	
	@Override
	public String toString(){return this.template.toString();}

}
