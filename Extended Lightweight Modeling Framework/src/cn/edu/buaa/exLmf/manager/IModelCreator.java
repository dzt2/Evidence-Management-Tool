package cn.edu.buaa.exLmf.manager;

import java.util.Set;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LModelElement;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;

public interface IModelCreator {
	
	public static int UNIQUE_ORDER = 0;
	public static int UNIQUE_INORDER = 1;
	public static int INUNIQUE_ORDER = 2;
	public static int INUNIQUE_INORDER = 3;
	
	public LPackage createPackage(String name);
	public LPackage createPackage(String name,String nsURI,String prefix);
	
	public LClass createClass(String name);
	public LClass createClass(String name,String ins);
	
	public LClass createAbstractClass(String name);
	public LClass createAbstractClass(String name,String ins);
	
	public LClass createFinalClass(String name);
	public LClass createFinalClass(String name,String ins);
	
	public LEnum createEnum(String name);
	public LEnum createEnum(String name,String ins);
	
	public LAttribute createAttribute(String name,LDataType type);
	public LAttribute createConstantAttribute(String name,LDataType type);
	public LAttribute createMultipleAttribute(String name,LDataType type,int lower,int upper,int multipleType);
	
	public LReference createReference(String name,LClass type);
	public LReference createConstantReference(String name,LClass type);
	public LReference createMultipleReference(String name,LClass type,int lower,int upper,int multipleType);
	
	public LEnumLiteral createLiteral(String name,int value);
	public LEnumLiteral createLiteral(String name,int value,String literal);
	
	public Set<Integer> getIDs();
	public LModelElement getElement(Integer id);
	public Integer getIDOf(LModelElement elm);
	public Boolean containElement(LModelElement elm);
	public Boolean removeElement(LModelElement elm);
	
	public Boolean updateSpace();
}
