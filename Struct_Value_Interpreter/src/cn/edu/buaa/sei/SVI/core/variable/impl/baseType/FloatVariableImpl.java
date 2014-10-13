package cn.edu.buaa.sei.SVI.core.variable.impl.baseType;

import cn.edu.buaa.sei.SVI.core.variable.baseType.FloatVariable;
import cn.edu.buaa.sei.SVI.core.variable.impl.TypedVariableImpl;

public class FloatVariableImpl extends TypedVariableImpl implements FloatVariable{

	public FloatVariableImpl(String name) throws Exception {super(name, Float.class);}
	@Override
	public void assign(Float val) throws Exception {this.val=val;}
	@Override
	public Float read() throws Exception {
		if(this.val==null)return null;
		else return (Float) this.val;
	}
}
