package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface RangeQuantifier extends QuantifierOperator{
	public int getLowerBound();
	public int getUpperBound();
	
	public void setLowerBound(int lower) throws Exception;
	public void setUpperBound(int upper) throws Exception;
}
