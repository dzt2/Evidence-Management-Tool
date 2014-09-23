package cn.edu.buaa.sei.logicAC.meta.common.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.Variable;
import cn.edu.buaa.sei.logicAC.meta.common.VariablePool;

public class FixedVariableList implements VariablePool{
	public static final int MAXLIST_SIZE = 256;
	String[] names = new String[MAXLIST_SIZE];
	Variable[] list = new Variable[MAXLIST_SIZE];
	int len=0;
	
	class _VIter implements Iterator<Variable>{
		
		int cur=0;
		
		@Override
		public boolean hasNext() {return cur<len;}

		@Override
		public Variable next() {return list[cur++];}

		@Override
		public void remove() {
			for(int i=cur;i<len-1;i++)
				list[i]=list[i+1];
		}
		
	}

	@Override
	public Iterator<Variable> iterator() {return new _VIter();}

	@Override
	public int size() {return this.len;}

	@Override
	public Variable getVariableByName(String name) throws Exception {
		if(name==null)
			throw new Exception("Null name must not be contained in the pool");
		
		int i;
		for(i=0;i<this.len;i++)
			if(names[i].equals(name))break;
		
		if(i>=len)throw new Exception(name+" has not been appended in the pool");
		return this.list[i];
	}

	@Override
	public Set<String> getNames() {
		Set<String> names = new HashSet<String>();
		for(int i=0;i<len;i++)
			names.add(this.names[i]);
		return names;
	}

	@Override
	public void putVariable(Variable var) throws Exception {
		if(var==null)throw new Exception("Null variable is invalid");
		if(len>=MAXLIST_SIZE)throw new Exception("Out of the limitaion: "+MAXLIST_SIZE);
		
		int i;
		for(i=0;i<len;i++)
			if(this.names[i].equals(var.getName())){
				if(this.list[i]==var)return;
				else throw new Exception("Name conflict at index <"+i+">: "+var.getName());
			}
		
		this.names[len]=var.getName();
		this.list[len++]=var;
	}

	@Override
	public void deleteVariable(Variable var) throws Exception {
		int i;
		for(i=0;i<len;i++)
			if(this.list[i]==var)break;
		
		if(i>=this.len)throw new Exception("Variable has not been defined in the pool");
		
		for(int j=i;j<len-1;j++){
			this.list[j]=this.list[j+1];
			this.names[j]=this.names[j+1];
		}
		this.len--;
	}

	@Override
	public boolean containVariable(Variable var){
		int i;
		for(i=0;i<len;i++)
			if(this.list[i]==var)break;
		
		if(i>=this.len)return false;
		else return true;
	}
}
