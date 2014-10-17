package cn.edu.buaa.sei.SVI.interpreter.group.impl;

import java.util.Iterator;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.group.ConditionGroup;
import cn.edu.buaa.sei.SVI.struct.group.EnumerateGroup;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;

public class ConditionGroupImpl implements ConditionGroup{
	
	LogicFunction function;
	Variable variable;
	EnumerateGroup universal;
	
	public ConditionGroupImpl(LogicFunction function,EnumerateGroup universal) throws Exception{
		if(function==null||universal==null)
			throw new Exception("Null Function|Universal is invalid");
		
		FunctionTemplate template = function.getTemplate();
		if(template==null)
			throw new Exception("Structure Error: null template");
		if(template.getArguments()==null||template.getArguments().length!=1)
			throw new Exception("Template Structure Error: hope to be \'F(x)\'");
		
		this.function=function;
		this.universal=universal;
		this.variable = template.getArguments()[0];
	}
	
	@Override
	public int size() {
		int count = 0;
		
		try {
			Inferencer inferencer = (Inferencer) Interpreter.register.get(this.function);
			
			Iterator<Object> itor = this.universal.iterator();
			while(itor.hasNext()){
				Object val = itor.next();
				try{
					this.variable.assign(val);
					Boolean result = inferencer.interpret(this.function);
					if(result!=null&&result==true)
						count++;
				}
				catch(Exception ex){continue;}
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
		
		return count;
	}
	@Override
	public boolean contains(Object val) {
		try {
			Inferencer inferencer = (Inferencer) Interpreter.register.get(this.function);
			
			if(this.universal.contains(val)){
				try{
					this.variable.assign(val);
					Boolean result = inferencer.interpret(function);
					if(result!=null)return result;
					else return false;
				}
				catch(Exception ex){
					System.err.println(ex.getMessage());
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public LogicFunction getCondition() {return this.function;}
	@Override
	public Variable getVariable() {return this.variable;}

}
