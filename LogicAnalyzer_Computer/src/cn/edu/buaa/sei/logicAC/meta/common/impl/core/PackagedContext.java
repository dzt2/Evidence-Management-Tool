package cn.edu.buaa.sei.logicAC.meta.common.impl.core;

import java.util.Iterator;

import cn.edu.buaa.sei.logicAC.meta.common.core.Context;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextDependComputable;

public abstract class PackagedContext implements Context{
	Context context;
	
	protected PackagedContext(Context context) throws Exception{
		if(context==null)
			throw new NullPointerException("Context cannot be null in a packaged context");
		this.context=context;
	}
	
	@Override
	public boolean containComputableUnit(ContextDependComputable unit) {return this.context.containComputableUnit(unit);}
	@Override
	public void addComputableUnit(ContextDependComputable unit) throws Exception {this.context.addComputableUnit(unit);}
	@Override
	public void removeComputableUnit(ContextDependComputable unit) throws Exception {this.context.removeComputableUnit(unit);}
	@Override
	public Iterator<ContextDependComputable> getComputableUnits() {return this.context.getComputableUnits();}

}
