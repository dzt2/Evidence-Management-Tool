package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LTypedElement;

public abstract class LTypedElementImpl extends LNamedElementImpl implements LTypedElement{
	
	LClassifier type;
	Boolean ordered=true;
	Boolean unique=false;
	int lowerBound = 0;
	int upperBound = 1;
	
	public static final int UNBOUNDED = -1;
	
	LTypedElementImpl(){super();}
	LTypedElementImpl(String name){super(name);}

	@Override
	public LClassifier getType() {return this.type;}
	@Override
	public void setType(LClassifier type) {
		if(type==null){
			try {
				throw this.getException("setType(type)", "type", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.type=type;
	}

	@Override
	public Boolean isOrdered() {return this.ordered;}
	@Override
	public Boolean isUnique() {return this.unique;}

	@Override
	public int getUpperBound() {return this.upperBound;}
	@Override
	public int getLowerBound() {return this.lowerBound;}

	@Override
	public void setOrdered(boolean ordered) {this.ordered=ordered;}
	@Override
	public void setUnique(boolean unique) {this.unique=unique;}

	@Override
	public void setUpperBound(int upperBound) {
		if(upperBound<0&&upperBound!=UNBOUNDED){
			try {
				throw this.getException("setUpperBound(upperBound)", "upperBound", 
						"Invalid integer: "+upperBound);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		/*if(upperBound<this.lowerBound){
			try {
				throw this.getException("setUpperBound(upperBound)", "upperBound", 
						"Out of range: upper = "+upperBound+", lower = "+this.lowerBound);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}*/
		this.upperBound=upperBound;
	}
	@Override
	public void setLowerBound(int lowerBound) {
		if(lowerBound<0){
			try {
				throw this.getException("setLowerBound(lowerBound)", "lowerBound", 
						"Invalid integer: "+lowerBound);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		/*if(lowerBound>this.upperBound&&this.upperBound>=0){
			
		}*/
		this.lowerBound=lowerBound;
	}

}
