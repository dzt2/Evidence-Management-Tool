package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface AtMostQuantifier extends QuantifierOperator{
	public static final int UNBOUNDED = -1;
	
	public int getUpperBound();
	public void setUpperBound(int upper) throws Exception;
}
