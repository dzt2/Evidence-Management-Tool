package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface AtLeastQuantifier extends QuantifierOperator{
	public int getLowerBound();
	public void setLowerBound(int lower) throws Exception;
}
