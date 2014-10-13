package cn.edu.buaa.sei.SVI.logic.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.function.Function;
import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.logic.LogicVariable;

public class LogicFunctionTemplateImpl implements LogicFunctionTemplate{
	CompositeStruct container;
	LogicFunction function;
	LogicVariable out;
	Variable[] arguments;
	String name;
	
	public static final String OUT_NAME = "out";
	
	/**
	 * For any FunctionTemplate, name and container must not be null.<br>
	 * However, arguments is null, which means a function like: int f()<br>
	 * The containing function is set after constructing.<br>
	 * For children: [out, a1, a2, ..., an]
	 * */
	public LogicFunctionTemplateImpl(String name,Variable[] arguments,CompositeStruct container) throws Exception{
		if(name==null)
			throw new Exception("Function Name should not be null");
		if(container==null)
			throw new Exception("The container must not be null");
		
		this.name=name;
		this.arguments=arguments;
		this.out = new LogicVariableImpl(OUT_NAME);
		this.container=container;
		
		this.container.addChildStruct(out);
		if(this.arguments!=null){
			for(int i=0;i<this.arguments.length;i++){
				Variable ai = this.arguments[i];
				if(ai==null)
					throw new Exception("Arguments["+i+"] is null");
				this.container.addChildStruct(ai);
			}
		}
		
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
	public boolean containChildStruct(Struct child) {return this.container.containChildStruct(child);}

	@Override
	public int getChildrenStructSize() {return this.container.getChildrenStructSize();}

	@Override
	public String getName() {return this.name;}

	@Override
	public Variable[] getArguments() {return this.arguments;}

	@SuppressWarnings("null")
	@Override
	public void assign(Object[] values) throws Exception {
		if(this.arguments==null){
			if(values!=null||values.length!=0)
				throw new Exception("Argument is empty");
		}
		else{
			if(values==null)
				throw new Exception("Null value list is invalid");
			if(values.length!=this.arguments.length)
				throw new Exception("Value List length not matches Arguments length: ["
						+values.length+"--"+this.arguments.length+"]");
			
			for(int i=0;i<this.arguments.length;i++){
				this.arguments[i].assign(values[i]);
			}
		}
	}

	@Override
	public void setFunction(Function function) {this.function=(LogicFunction) function;}

	@Override
	public LogicVariable getOutput() {return this.out;}

	@Override
	public LogicFunction getFunction() {return this.function;}

	@Override
	public void setFunction(LogicFunction function) {this.function=function;}
	
	@Override
	public String toString(){
		StringBuilder code = new StringBuilder();
		
		code.append("boolean ").append(this.name).append("(");
		for(int i=0;i<this.arguments.length;i++){
			code.append(this.arguments[i].toString());
			if(i!=this.arguments.length-1)
				code.append(",");
		}
		code.append(")");
		
		return code.toString();
	}
	
}
