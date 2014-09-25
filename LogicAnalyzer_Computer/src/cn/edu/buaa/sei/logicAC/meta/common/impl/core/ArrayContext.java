package cn.edu.buaa.sei.logicAC.meta.common.impl.core;

import java.util.Iterator;
import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextDependComputable;

public class ArrayContext implements Context{
	ContextDependComputable[] units;
	public static final int DEFAULT_SIZE = 256;
	public static final int SMALL_SIZE = 64;
	public static final int NORMAL_SIZE = 256;
	public static final int LARGE_SIZE = 1024;
	int len = 0;
	
	public ArrayContext(int size) throws Exception{
		if(size<=0) throw new Exception("Invalid size argument: "+size);
		this.units = new ContextDependComputable[size];
	}
	public ArrayContext(){this.units=new ContextDependComputable[DEFAULT_SIZE];}
	
	@Override
	public boolean containComputableUnit(ContextDependComputable unit) {
		if(unit==null)return false;
		for(int i=0;i<this.len;i++)
			if(unit==this.units[i])return true;
		return false;
	}

	@Override
	public void addComputableUnit(ContextDependComputable unit)
			throws Exception {
		if(unit==null)
			throw new NullPointerException("Null computable cannot be in the context");
		if(this.containComputableUnit(unit))return;
		if(this.len>=this.units.length)
			throw new Exception("The context has been flowed out");
		
		this.units[this.len++]=unit;
		if(unit.getContext()!=null)
			unit.getContext().removeComputableUnit(unit);
		unit.setContext(this);
	}

	@Override
	public void removeComputableUnit(ContextDependComputable unit)
			throws Exception {
		if(unit==null)
			throw new NullPointerException("Null unit is not in the context");
		
		int i;
		for(i=0;i<this.len;i++)
			if(unit==this.units[i])break;
		if(i>=this.len)
			throw new Exception("Unit is not in the context");
		
		unit.setContext(null);
		for(int j=i;j<this.len-1;j++)
			this.units[j]=this.units[j+1];
		this.len--;
	}
	@Override
	public Iterator<ContextDependComputable> getComputableUnits() {return new _VIter();}

	class _VIter implements Iterator<ContextDependComputable>{
		int cur=0;
		@Override
		public boolean hasNext() {return cur<=len;}

		@Override
		public ContextDependComputable next() {
			if(!this.hasNext())return null;
			return units[cur++];
		}

		@Override
		public void remove() {
			if(len<=0)return;
			for(int i=cur;i<len-1;i++)
				units[i]=units[i+1];
			len--;
		}
	}

}
