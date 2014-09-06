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
	
	public static final int UNIQUE_ORDER = 0;
	public static final int UNIQUE_INORDER = 1;
	public static final int INUNIQUE_ORDER = 2;
	public static final int INUNIQUE_INORDER = 3;
	public static final String _ROOT = "";
	public static final String nsURI = "www.lmf.com/manager";
	public static final String prefix = "";
	
	public LPackage getRoot();
	
	public LPackage createPackage(LPackage container,String name) throws Exception;
	public LPackage createPackage(LPackage container,String name,String nsURI,String prefix) throws Exception;
	
	public LClass createClass(LPackage container,String name) throws Exception;
	public LClass createClass(LPackage container,String name,String ins) throws Exception;
	
	public LClass createAbstractClass(LPackage container,String name) throws Exception;
	public LClass createAbstractClass(LPackage container,String name,String ins) throws Exception;
	
	public LClass createFinalClass(LPackage container,String name) throws Exception;
	public LClass createFinalClass(LPackage container,String name,String ins) throws Exception;
	
	public LEnum createEnum(LPackage container,String name) throws Exception;
	public LEnum createEnum(LPackage container,String name,String ins) throws Exception;
	
	public LAttribute createAttribute(LClass container,String name,LDataType type) throws Exception;
	public LAttribute createConstantAttribute(LClass container,String name,LDataType type) throws Exception;
	public LAttribute createMultipleAttribute(LClass container,String name,LDataType type,int lower,int upper,int multipleType) throws Exception;
	
	public LReference createReference(LClass container,String name,LClass type) throws Exception;
	public LReference createConstantReference(LClass container,String name,LClass type) throws Exception;
	public LReference createMultipleReference(LClass container,String name,LClass type,int lower,int upper,int multipleType) throws Exception;
	
	public LEnumLiteral createLiteral(LEnum container,String name,int value) throws Exception;
	public LEnumLiteral createLiteral(LEnum container,String name,int value,String literal) throws Exception;
	
	public Set<Integer> getIDs();
	public LModelElement getElement(Integer id);
	public Integer getIDOf(LModelElement elm);
	public Boolean containElement(LModelElement elm);
	public Boolean removeElement(LModelElement elm);
	
	public Boolean updateSpace() throws Exception;
}
