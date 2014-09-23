package cn.edu.buaa.sei.logicAC.meta.common.impl;

public class SafeTypedVariable extends TypedVariableImpl{

	public SafeTypedVariable(String name,Class<?> type) throws Exception {
		super(name,type);
	}
	
	/**
	 * Set the val with a new value that is referred by the typed variable. <br>
	 * If the val is incompatible with the type, an exception would be reported but not thrown.<br>
	 * This function has been re-coverred so to process exception report when incompatible assignment is tried.
	 * @exception Exception
	 * */
	@Override
	public void assign(Object val) throws Exception {
		if(this.compatible(val))
			this.val=val;
		else
			System.err.println("Incompatible assignment: "+this.type.getName()+
					" := "+val.getClass().getName()+"\nThe assignment for variable "
					+this.getName()+" has been aborted...");
	}

}
