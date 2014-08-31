package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LObject;

public abstract class LClassifierImpl extends LNamedElementImpl implements LClassifier{
	
	int id=DEFAULT_ID;
	public static final int DEFAULT_ID = -1;
	
	LClassifierImpl(){super();}
	LClassifierImpl(String name){super(name);}
	
	@Override
	public int getClassifierID() {return this.id;}
	@Override
	public void setClassifierID(int id) {this.id=id;}

	@Override
	public String getInstanceName() {
		return this.getName();
	}
	@Override
	public LObject getDefaultValue() {
		return null;
	}
	
}
