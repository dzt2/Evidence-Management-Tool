package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LDataType;

public class LAttributeImpl extends LStructuralFeatureImpl implements LAttribute{
	
	LDataType dtype;
	
	public LAttributeImpl(int fid,String name,LClassifier container){
		super(fid,name,container);
	}
	
	
	@Override
	public LDataType getDataType() {return this.dtype;}
	@Override
	public void setDataType(LDataType type) {
		this.setType(type);
	}
	public void setType(LClassifier type){
		if((type==null)||!(type instanceof LDataType)){
			try {
				throw this.getException("setType(type)", "type", "Attribute's type must be LDataType");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		super.setType(type);
		this.dtype=(LDataType) type;
	}
}
