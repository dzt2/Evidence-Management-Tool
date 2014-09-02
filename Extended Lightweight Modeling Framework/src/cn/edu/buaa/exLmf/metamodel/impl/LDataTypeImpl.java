package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LPackage;

public abstract class LDataTypeImpl extends LClassifierImpl implements LDataType{
	LDataTypeImpl(String name,LPackage container){super(name,container);}
}
