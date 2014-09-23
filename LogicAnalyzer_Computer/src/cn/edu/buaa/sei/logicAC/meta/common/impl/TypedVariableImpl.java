package cn.edu.buaa.sei.logicAC.meta.common.impl;

import cn.edu.buaa.sei.logicAC.meta.common.TypedVariable;

/**
 * TypedVariableImpl is the implementation of interface TypedVariable <br>
 * TypedVariableImpl is not abstract and could be directly constructed.
 * */
public class TypedVariableImpl extends VariableImpl implements TypedVariable{
	/**
	 * The type that bind to the variable, whose value must be compatible with the type
	 * */
	Class<?> type=Object.class;
	
	/**
	 * TypedVariableImpl is public constructor and implement based on VariableImpl(abstract)
	 * */
	public TypedVariableImpl(String name,Class<?> type) throws Exception {
		super(name);
		if(type==null)throw new Exception("No type is specified in constructing a typed variable");
		this.type=type;
	}

	/**
	 * Return the type which is binded to the value referred by the variable.
	 * @return this.type
	 * */
	@Override
	public Class<?> getType() {return this.type;}

	/**
	 * Return whether the value that user try to assign is compatible with the type binded to this variable.
	 * @return this.type.isInstance(object)
	 * */
	@Override
	public boolean compatible(Object object) {
		// TODO Auto-generated method stub
		if(object==null)return true;
		return this.type.isInstance(object);
	}
	
	/**
	 * Set the val with a new value that is referred by the typed variable. <br>
	 * If the val is incompatible with the type, an exception would be caused.<br>
	 * This function has been re-coverred so to process type incompatibility.
	 * @exception Exception
	 * */
	@Override
	public void assign(Object val) throws Exception {
		if(this.compatible(val))
			this.val=val;
		else
			throw new Exception("Incompatible assignment: "+this.type.getName()+
					" := "+val.getClass().getName());
	}

}
