package cn.edu.buaa.sei.exLmf.metamodel.impl;

import cn.edu.buaa.sei.exLmf.metamodel.LNamedElement;

public abstract class LNamedElementImpl extends LModelElementImpl implements LNamedElement{
	
	String name;
	
	LNamedElementImpl(String name){
		super();
		this.setName(name);
	}

	@Override
	public String getName() {return this.name;}
	@Override
	public void setName(String name) {
		if(name==null){
			try {
				throw this.getException("setName(name)","name", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.name=name;
	}

}
