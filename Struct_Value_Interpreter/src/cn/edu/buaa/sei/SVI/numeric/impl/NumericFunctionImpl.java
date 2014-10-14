package cn.edu.buaa.sei.SVI.numeric.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.function.Context;
import cn.edu.buaa.sei.SVI.core.function.FunctionBody;
import cn.edu.buaa.sei.SVI.numeric.NumericFunction;
import cn.edu.buaa.sei.SVI.numeric.NumericFunctionTemplate;

public class NumericFunctionImpl implements NumericFunction{
	
	NumericFunctionTemplate template;
	CompositeStruct container;
	
	Context context;
	FunctionBody body;
	
	/**
	 * Children: [template,{context},{body}]
	 * */
	NumericFunctionImpl(NumericFunctionTemplate template,CompositeStruct container) throws Exception{
		if(template==null||container==null)
			throw new Exception("Null Template|Container is invalid");
		
		this.template=template;
		this.container=container;
		
		this.container.addChildStruct(template);
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
	public void setContext(Context context) {
		if(this.context!=null)
			try {
				if(this.body!=null)
					this.container.removeChildStruct(this.body);
				this.container.removeChildStruct(this.context);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.context=context;
		if(this.context!=null)
			try {
				this.container.addChildStruct(this.context);
				if(this.body!=null)
					this.container.addChildStruct(this.body);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void setBody(FunctionBody body) {
		if(this.body!=null)
			try {
				this.container.removeChildStruct(this.body);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.body=body;
		if(this.body!=null)
			try {
				this.container.addChildStruct(this.body);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public NumericFunctionTemplate getTemplate() {
		return this.template;
	}

}
