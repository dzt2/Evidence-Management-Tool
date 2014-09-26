package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface RangeQuantifier extends QuantifierOperator{
	public static final int UNBOUNDED = -1;
	
	public int getLowerBound();
	public int getUpperBound();
	
	public void setBound(int lower,int upper) throws Exception;
}
