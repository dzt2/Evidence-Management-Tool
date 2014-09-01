package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;

public class LEnumLiteralImpl extends LStructuralFeatureImpl implements LEnumLiteral{

	int value;
	String literal;
	
	LEnumLiteralImpl(int fid, String name, LClassifier container) {
		super(fid, name, container);
	}
	
	@Override
	public int getValue() {return this.value;}
	@Override
	public void setValue(int value) {this.value=value;}
	@Override
	public String getLiteral() {return this.literal;}
	@Override
	public void setLiteral(String literal) {this.literal=literal;}

}
