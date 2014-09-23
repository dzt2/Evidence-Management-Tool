package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface AtLeastQuantifier extends Quantification{
	public int getLowerBound();
	public void setLowerBound(int lower);
}
