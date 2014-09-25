package cn.edu.buaa.sei.logicAC.meta.common.impl.var;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public abstract class TypedVariableImpl extends VariableImpl implements TypedVariable{
	Class<?> type = Object.class;

	protected TypedVariableImpl(String name,Class<?> type) throws Exception {
		super(name);
		if(type==null)
			throw new NullPointerException("TypedVariable needs to be declared for its type at begining");
		this.type=type;
	}

	@Override
	public void assign(Object val) throws Exception {
		if(val==null)
			throw new NullPointerException("Variable is set to an invalid address");
		if(!this.isCompatible(val))
			throw new ClassCastException("Cannot cast the "+val.getClass().getName()
					+" value to "+this.type.getName()+" variable");
		this.val=val;
	}

	@Override
	public Class<?> getType() {return this.type;}

	@Override
	public boolean isCompatible(Object val) {
		return this.type.isInstance(val);
	}

}
