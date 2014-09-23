package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface RangeQuantifier extends Quantification{
	public int getLowerBound();
	public int getUpperBound();
	
	public void setBound(int lower,int upper);
}
