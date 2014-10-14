package cn.edu.buaa.sei.SVI.numeric.impl;

import cn.edu.buaa.sei.SVI.core.variable.impl.TypedVariableImpl;
import cn.edu.buaa.sei.SVI.numeric.NaturalVariable;

public class NaturalVariableImpl extends TypedVariableImpl implements NaturalVariable{
	
	protected NaturalVariableImpl(String name) throws Exception {
		super(name, Long.class);
	}

	@Override
	public void assign(Number val) throws Exception {
		if(val==null)this.val=null;
		else if(val instanceof Integer){
			int x = (Integer) val;
			long y = x;
			this.assign(y);
		}
		else if(!(val instanceof Long))
			throw new Exception("Long value required");
		else{
			Long t = (Long) val;
			this.assign(t);
		}
	}

	@Override
	public void assign(Long val) throws Exception {
		if(val==null||val>=0)this.val=val;
		else throw new Exception("Invalid Natural Number: "+val);
	}
	
	@Override
	public Long read() throws Exception{
		if(this.val==null)return null;
		else return (Long) this.val;
	}

}
