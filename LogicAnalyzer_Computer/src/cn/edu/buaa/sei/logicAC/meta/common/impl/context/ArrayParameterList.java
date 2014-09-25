package cn.edu.buaa.sei.logicAC.meta.common.impl.context;

import cn.edu.buaa.sei.logicAC.meta.common.context.NormativeParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.PackagedContext;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class ArrayParameterList extends PackagedContext implements NormativeParameterList{
	public static final int INIT_SIZE = 8;
	public static final int TIMES = 2;
	
	Variable output;
	Variable[] arguments;
	int len = 0;

	protected ArrayParameterList(Context context) throws Exception {
		super(context);
		this.arguments = new Variable[INIT_SIZE];
	}

	@Override
	public void setOutputParameter(Variable parameter) {this.output=parameter;}
	@Override
	public Variable getOutputParameter() {return this.output;}

	@Override
	public void addArgument(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable is invalid to be an argument");
		
		int i;
		for(i=0;i<this.len;i++)
			if(this.arguments[i]==variable)return;
		
		if(this.len>=MAX_ARGUMENTS)
			throw new Exception("Out of the limitation of argument list: "+this.len);
		if(this.len>=this.arguments.length){
			Variable[] list = new Variable[this.arguments.length*TIMES];
			for(i=0;i<this.arguments.length;i++)
				list[i]=this.arguments[i];
			this.arguments=list;
		}
		
		this.arguments[this.len++]=variable;
	}
	@Override
	public void removeArgument(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable is not in the parameter list");
		int i;
		for(i=0;i<this.len;i++)
			if(this.arguments[i]==variable)break;
		if(i>=this.len)
			throw new Exception("Variable is not in the arguments");
		
		for(int j=i;j<this.len-1;j++)
			this.arguments[j]=this.arguments[j+1];
		this.len--;
	}
	@Override
	public boolean containArgument(Variable variable) {
		if(variable==null)return false;
		for(int i=0;i<this.len;i++)
			if(variable==this.arguments[i])return true;
		return false;
	}
	@Override
	public int argumentSize() {return this.len;}
	@Override
	public Variable getArgument(int i) throws Exception {
		if(i<0||i>=this.len)
			throw new Exception("Out of range: "+i+" hope to be in [0,"+this.len+")");
		return this.arguments[i];
	}

}
