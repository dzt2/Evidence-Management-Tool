package cn.edu.buaa.sei.exLmf.metamodel.impl;

import cn.edu.buaa.sei.exLmf.metamodel.LClassifier;
import cn.edu.buaa.sei.exLmf.metamodel.LObject;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public class LClassifierImpl extends LNamedElementImpl implements LClassifier{
	
	String ins_name;
	LObject default_val;
	int id=DEFAULT_ID;
	public static final int DEFAULT_ID = -1;
	LPackage container;
	
	LClassifierImpl(String name,LPackage container){super(name);this.container=container;}
	
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

	@Override
	public LPackage getContainer() {return this.container;}

	@Override
	public void setContainer(LPackage container) {this.container=container;}
	
}
