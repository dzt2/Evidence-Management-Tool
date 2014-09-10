package cn.edu.buaa.sei.exLmf.metamodel;

public interface LTypedElement extends LNamedElement{
	public LClassifier getType();
	public void setType(LClassifier type);
	public Boolean isOrdered();
	public Boolean isUnique();
	public int getUpperBound();
	public int getLowerBound();
	
	public void setOrdered(boolean ordered);
	public void setUnique(boolean unique);
	public void setUpperBound(int upperBound);
	public void setLowerBound(int lowerBound);
}
