package cn.edu.buaa.sei.SVI.core.function.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.StructArray;
import cn.edu.buaa.sei.SVI.core.function.Function;
import cn.edu.buaa.sei.SVI.core.function.FunctionBodyAPI;

public abstract class FunctionBodyAPIImpl implements FunctionBodyAPI{
	CompositeStruct container = new StructArray();
	Function function;

	@Override
	public Function getFunction() {return this.function;}

	@Override
	public void setFunction(Function function) {this.function=function;}

	@Override
	public Struct[] getChildrenStructs() {return this.container.getChildrenStructs();}

	@Override
	public void addChildStruct(Struct child) throws Exception {this.container.addChildStruct(child);}

	@Override
	public void removeChildStruct(Struct child) throws Exception {this.container.removeChildStruct(child);}

	@Override
	public boolean containChildStruct(Struct child) {return this.container.containChildStruct(child);}

	@Override
	public int getChildrenStructSize() {return this.container.getChildrenStructSize();}
}
