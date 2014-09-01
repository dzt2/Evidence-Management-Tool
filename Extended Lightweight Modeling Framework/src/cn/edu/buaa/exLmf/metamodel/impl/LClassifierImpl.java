package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LObject;

public abstract class LClassifierImpl extends LNamedElementImpl implements LClassifier{
	
	String ins_name;
	LObject default_val;
	int id=DEFAULT_ID;
	public static final int DEFAULT_ID = -1;
	
	LClassifierImpl(String name){super(name);}
	
	@Override
	public int getClassifierID() {return this.id;}
	@Override
	public void setClassifierID(int id) {this.id=id;}

	@Override
	public String getInstanceName() {
		return this.ins_name;
	}
	@Override
	public LObject getDefaultValue() {
		return this.default_val;
	}
	@Override
	public void setInstanceName(String ins) {
		// TODO Auto-generated method stub
		this.ins_name=ins;
	}
	@Override
	public LObject setDefaultValue(LObject val) {
		// TODO Auto-generated method stub
		return this.default_val=val;
	}
	
}
