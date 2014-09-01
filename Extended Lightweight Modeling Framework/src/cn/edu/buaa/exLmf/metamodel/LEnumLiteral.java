package cn.edu.buaa.exLmf.metamodel;

public interface LEnumLiteral extends LStructuralFeature{
	public int getValue();
	public void setValue(int value);
	public String getLiteral();
	public void setLiteral(String literal);
}
