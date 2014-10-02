package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;
import cn.edu.buaa.sei.logicAC.meta.common.impl.var.base.BaseVariableFactory;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.BooleanVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;

public class LogicFunctionTemplateImpl implements LogicFunctionTemplate{
	String name;
	
	BooleanVariable return_var;
	Variable[] arguments;
	
	LogicFunctionTemplateImpl(String name,Variable[] arguments) throws Exception{
		if(name==null)
			throw new Exception("Null name is invalid");
		this.name=name;
		return_var=(BooleanVariable) BaseVariableFactory.createVariable("RETURN", BaseVariableFactory.BOOLEAN);
		this.arguments=arguments;
	}
	
	@Override
	public String getName() {return this.name;}
	@Override
	public BooleanVariable getOutputVariable() {return this.return_var;}
	
	@Override
	public Variable[] getArguments() {return this.arguments;}

	@Override
	public void setArguments(Variable[] arguments) throws Exception {
		if(arguments!=null){
			for(int i=0;i<arguments.length;i++){
				if(arguments[i]==null)
					throw new Exception("arguments["+i+"] is null invalid");
			}
		}
		this.arguments=arguments;
	}


}
