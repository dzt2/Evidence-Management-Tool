package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface AtLeastQuantifier extends Quantifier{
	public int getLowerBound();
	public void setLowerBound(int lower) throws Exception;
}
