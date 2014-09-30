package cn.edu.buaa.sei.logicAC.meta.common.impl.context;

import java.util.Iterator;

import cn.edu.buaa.sei.logicAC.meta.common.context.VariablePool;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.PackagedContext;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class ArrayVariablePool extends PackagedContext implements VariablePool{
	Variable[] variables;
	int len=0;
	
	public static final int MAX_SIZE = 1024;
	public static final int TIMES = 4;
	public static final int DEFAULT_SIZE = 256;
	public static final int SMALL_SIZE = 64;
	public static final int LARGE_SIZE = 1024;
	public static final int NORMAL_SIZE = 256;

	ArrayVariablePool(Context context) throws Exception {
		super(context);
		this.variables=new Variable[DEFAULT_SIZE];
	}
	ArrayVariablePool(Context context,int size) throws Exception{
		super(context);
		if(size<=0)
			throw new Exception("Invalid size initialization: "+size);
		this.variables = new Variable[size];
	}

	@Override
	public boolean containVariable(Variable variable) {
		if(variable==null)return false;
		
		for(int i=0;i<this.len;i++)
			if(variable==this.variables[i])return true;
		return false;
	}

	@Override
	public void appendVariable(Variable variable) throws Exception {
		if(variable==null)
			throw new Exception("Null variable cannot be added in the pool");
		
		int i;
		for(i=0;i<this.len;i++)
			if(this.variables[i]==variable)return;
		
		if(this.len>=MAX_SIZE)
			throw new Exception("Out of limitation of the pool: "+this.len);
		
		if(this.len>=this.variables.length){
			Variable[] list = new Variable[this.variables.length*TIMES];
			for(i=0;i<this.variables.length;i++)
				list[i]=this.variables[i];
			this.variables=list;
		}
		
		this.variables[this.len++]=variable;
	}

	@Override
	public void removeVariable(Variable variable) throws Exception {
		if(variable==null)
			throw new NullPointerException("Null variable cannot be in pool");
		
		int i;
		for(i=0;i<this.len;i++)
			if(variable==this.variables[i])
				break;
		
		if(i>=this.len)
			throw new Exception("Variable is not in the pool");
		
		for(int j=i;j<this.len-1;j++)
			this.variables[j]=this.variables[j+1];
		this.len--;
	}

	@Override
	public Iterator<Variable> iterator() {
		// TODO Auto-generated method stub
		return new _VIter();
	}
	
	class _VIter implements Iterator<Variable>{
		int cur=0;

		@Override
		public boolean hasNext() {return this.cur<len;}

		@Override
		public Variable next() {
			if(!this.hasNext())return null;
			return variables[cur++];
		}

		@Override
		public void remove() {
			if(len<=0)return;
			for(int j=cur;j<len-1;j++)
				variables[j]=variables[j+1];
			len--;
		}
	}
	

}
