package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LReference;

public class LReferenceImpl extends LStructuralFeatureImpl implements LReference{
	LClass ctype;
	LReference opposite;
	Boolean containment = false;
	
	public LReferenceImpl(int fid, LClassifier container) {
		super(fid, container);
	}
	public LReferenceImpl(int fid,String name,LClassifier container){
		super(fid,name,container);
	}

	@Override
	public LClass getLClass() {return this.ctype;}
	@Override
	public void setLClass(LClass type) {
		this.setType(type);
	}
	public void setType(LClassifier type){
		if((type==null)||!(type instanceof LClass)){
			try {
				throw this.getException("setType(type)", "type", "Reference's type must be LClass");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		super.setType(type);
		this.ctype=(LClass) type;
	}
	
	@Override
	public LReference getOpposite() {
		return this.opposite;
	}
	@Override
	public void setOpposite(LReference opposite) {
		if(this.opposite!=null){
			this.opposite.release_opposite();
		}
		this.release_opposite();
		
		this.link_opposite(opposite);
		if(opposite!=null){
			opposite.link_opposite(this);
		}
	}
	@Override
	public void release_opposite() {this.opposite=null;}
	@Override
	public void link_opposite(LReference opposite) {this.opposite=opposite;}
	
	@Override
	public Boolean isContainment() {return this.containment;}
	@Override
	public void setContainment(Boolean containment) {this.containment=containment;}

}
