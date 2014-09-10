package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.List;

public interface LEnum extends LDataType{
	public List<LEnumLiteral> getLiterals();
	public void addLiteral(LEnumLiteral literal);
	
	public LEnumLiteral getLiteralByValue(int value);
	public LEnumLiteral getLiteralByName(String literal);

	public void removeLiteral(LEnumLiteral literal);
	public Boolean containLiteral(LEnumLiteral literal);
}
