package cn.edu.buaa.sei.logicAC.meta.common.impl.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextDependComputable;

public class SetContext implements Context{
	Set<ContextDependComputable> set = new HashSet<ContextDependComputable>();
	
	@Override
	public boolean containComputableUnit(ContextDependComputable unit) {
		if(unit==null)return false;
		return this.set.contains(unit);
	}

	@Override
	public void addComputableUnit(ContextDependComputable unit)
			throws Exception {
		if(unit==null)
			throw new NullPointerException("Null unit cannot be added in the context");
		if(this.set.contains(unit))return;
		
		if(unit.getContext()!=null)
			unit.getContext().removeComputableUnit(unit);
		unit.setContext(this);
		this.set.add(unit);
	}

	@Override
	public void removeComputableUnit(ContextDependComputable unit)
			throws Exception {
		if(unit==null)
			throw new NullPointerException("Null unit cannot be in the context");
		if(!this.set.contains(unit))
			throw new Exception("unit is not in the context");
		
		this.set.remove(unit);
		unit.setContext(null);
	}

	@Override
	public Iterator<ContextDependComputable> getComputableUnits() {return this.set.iterator();}

}
