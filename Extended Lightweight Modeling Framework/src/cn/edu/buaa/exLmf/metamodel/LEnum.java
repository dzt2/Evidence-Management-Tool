package cn.edu.buaa.exLmf.metamodel;

import java.util.List;

public interface LEnum extends LDataType{
	public List<LEnumLiteral> getLiterals();
	public void addLiteral(LEnumLiteral literal);
	
	public LEnumLiteral getLiteralByValue(int value);
	public LEnumLiteral getLiteralByName(String literal);
}
