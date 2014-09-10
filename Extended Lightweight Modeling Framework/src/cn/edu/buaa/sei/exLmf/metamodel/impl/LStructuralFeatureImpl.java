package cn.edu.buaa.sei.exLmf.metamodel.impl;

import cn.edu.buaa.sei.exLmf.metamodel.LClassifier;
import cn.edu.buaa.sei.exLmf.metamodel.LObject;
import cn.edu.buaa.sei.exLmf.metamodel.LStructuralFeature;

public abstract class LStructuralFeatureImpl extends LTypedElementImpl implements LStructuralFeature{
	
	LClassifier container;
	Boolean changable=true;
	int fid;
	LObject default_val;
	
	LStructuralFeatureImpl(int fid,String name,LClassifier container){super(name);this.container=container;this.fid=fid;}

	@Override
	public LClassifier getContainer() {return this.container;}
	@Override
	public void setContainer(LClassifier type) {this.container=type;}
	
	@Override
	public Boolean isChangable() {return this.changable;}
	@Override
	public void setChangable(boolean changable) {this.changable=changable;}
	
	@Override
	public int getFeatureID() {return this.fid;}
	void setFeatureID(int id) {this.fid=id;}

	@Override
	public LObject getDefaultValue() {return this.default_val;}
	@Override
	public void setDefaultValue(LObject value) {this.default_val=value;}
	
	

}
