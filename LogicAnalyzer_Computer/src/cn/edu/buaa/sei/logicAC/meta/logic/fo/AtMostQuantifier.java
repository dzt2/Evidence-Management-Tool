package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface AtMostQuantifier extends QuantifierOperator{
	public int getUpperBound();
	public void setUpperBound(int upper) throws Exception;
}
