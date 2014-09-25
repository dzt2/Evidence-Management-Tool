package cn.edu.buaa.sei.logicAC.meta.common.impl.var;

import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public abstract class VariableImpl implements Variable{
	String name;
	Object val;
	
	protected VariableImpl(String name) throws Exception{
		if(name==null)
			throw new Exception("Try to construct variable without name");
		
		this.name=name;
	}

	@Override
	public Object read() throws Exception {
		if(this.val==null)
			throw new NullPointerException("Try to assess invalid address: the variable has not been initialized");
		return this.val;
	}

	@Override
	public Object getResult() {return this.val;}

	@Override
	public void setResult(Object result) {
		try {
			this.assign(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {return this.name;}

}
