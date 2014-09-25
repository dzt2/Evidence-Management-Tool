package cn.edu.buaa.sei.logicAC.meta.common.impl.var.base;

import java.sql.Date;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.TypedVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.DateVariable;

public class DateVariableImpl extends TypedVariableImpl implements DateVariable{

	protected DateVariableImpl(String name) throws Exception {
		super(name, Date.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assign(java.util.Date val) throws Exception {super.assign(val);}
	@Override
	public Date read() throws Exception{return (Date) super.read();}

}
