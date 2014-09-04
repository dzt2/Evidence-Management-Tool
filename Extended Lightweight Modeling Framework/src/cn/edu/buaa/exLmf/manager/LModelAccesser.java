package cn.edu.buaa.exLmf.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.exLmf.metamodel.LObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;
import cn.edu.buaa.exLmf.metamodel.LStructuralFeature;
import cn.edu.buaa.exLmf.metamodel.impl.LMFException;

public class LModelAccesser {
	
	public static final String DOT = ".";
	public static final String ROOT= "";
	
	/*	Package Member  */
	public static final String CLASS = "class";
	public static final String ENUM = "enum";
	public static final String PACKAGE = "package";
	/*	Class Member   */
	public static final String ATTRIBUTE = "attribute";
	public static final String REFERENCE = "reference";
	public static final String SUPER = "super";
	public static final String FEATURE = "feature";
	public static final String LITERAL = "literal";
	public static final String CONTAINER = "container";
	public static final String IDATTR = "id_attribute";
	/*	LStructuredFeature  */
	public static final String DEFAULT = "default";
	public static final String TYPE = "type";
	/*Attribute*/
	public static final String DATATYPE = "dtype";
	/*Reference*/
	public static final String CLASSTYPE = "ctype";
	public static final String OPPOSITE = "opposite";
	/*LEnumLiteral*/
	/*LObject*/
	//public static final String TYPE = "type";
	/*LDataObject*/
	//public static final String DATATYPE = "dtype";
	public static final String VALUE = "value";
	/*LClassObject*/
	//public static final String CLASSTYPE = "ctype";
	/*LMultipleObject*/
	public static final String PARAMETER_TYPE = "parameter_type";
	public static final String UNIQUE_INORDER = "u_io";
	public static final String UNIQUE_ORDER = "u_o";
	public static final String INUNIQUE_ORDER = "iu_o";
	public static final String INUNIQUE_INORDER = "iu_io";
	/*Tags*/
	public static final String LEFT = "[";
	public static final String RIGHT = "]";
	
	LPackage root;
	String name;
	
	public LModelAccesser(String name){
		this.name=name;
	}
	
	public LPackage getRoot(){return this.root;}
	public void setRoot(LPackage root){this.root=root;}
	
	/*	Tool Functions	*/
	static Exception generateException(String func,String arg,String reason){
		return LMFException.create("Model_Accesser", "LMFCreator", func, arg, reason);
	}
	Exception getException(String func,String arg,String reason){
		return LMFException.create("Model_Accesser "+this.name, "LMFCreator", func, arg, reason);
	}
	
	/*static Searcher Functions*/
	public static LPackage getSubPackage(LPackage parant,String name) throws Exception{
		if(parant==null||name==null){
			throw generateException("getSubPackage(parant,name)","parant|name","Null");
		}
		return parant.getSubPackageByName(name);
	}
	static List<LPackage> getSubPackages(LPackage parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getSubPackages(parant,child)","parant|child","Null");
		}
		if(child.equals(PACKAGE))return parant.getSubPackages();
		else throw generateException("getSubPackages(parant,child)",
				"child","\""+child+"\" does not match required \""+PACKAGE+"\"");
	}
	public static LClass getLClass(LPackage parant,String name) throws Exception{
		if(parant==null||name==null)
			throw generateException("getLClass(parant,name)","parant|name","Null");
		LClassifier type = null;
		
		try{
			Integer id = Integer.parseInt(name.trim());
			type = parant.getClassifierByID(id);
		}catch (Exception ex){
			type = parant.getClassifierByName(name);
		}
		
		if(type==null||!(type instanceof LClass))
			throw generateException("getLClass(parant,name)","name","LClass \""+name
					+"\" is not defined in package \""+parant.getName()+"\"");
		return (LClass) type;
	}
	static List<LClass> getLClasses(LPackage parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getLClasses(parant,child)","parant|child","Null");
		}
		if(child.equals(CLASS)){
			List<LClass> types = new ArrayList<LClass>();
			List<LClassifier> list = parant.getTypes();
			for(int i=0;i<list.size();i++)
				if(list.get(i) instanceof LClass)
					types.add((LClass) list.get(i));
			return types;
		}
		else throw generateException("getLClasses(parant,child)",
				"child","\""+child+"\" does not match required \""+CLASS+"\"");
	}
	public static LEnum getLEnum(LPackage parant,String name) throws Exception{
		if(parant==null||name==null)
			throw generateException("getLEnum(parant,name)","parant|name","Null");
		LClassifier type = null;
		
		try{
			Integer id = Integer.parseInt(name.trim());
			type = parant.getClassifierByID(id);
		}
		catch(Exception ex){
			type = parant.getClassifierByName(name);
		}
		
		if(type==null||!(type instanceof LEnum))
			throw generateException("getLClass(parant,name)","name","LClass \""+name
					+"\" is not defined in package \""+parant.getName()+"\"");
		return (LEnum) type;
	}
	static List<LEnum> getLEnums(LPackage parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getLEnums(parant,child)","parant|child","Null");
		}
		if(child.equals(ENUM)){
			List<LEnum> types = new ArrayList<LEnum>();
			List<LClassifier> list = parant.getTypes();
			for(int i=0;i<list.size();i++)
				if(list.get(i) instanceof LEnum)
					types.add((LEnum) list.get(i));
			return types;
		}
		else throw generateException("getLEnums(parant,child)",
				"child","\""+child+"\" does not match required \""+ENUM+"\"");
	}
	public static LAttribute getLAttribute(LClass parant,String name) throws Exception{
		if(parant==null||name==null){
			throw generateException("getLAttribute(parant,name)","parant|name","Null");
		}
		LStructuralFeature feature = null;
		
		try{
			Integer id = Integer.parseInt(name.trim());
			feature = parant.getFeatureByID(id);
		}catch(Exception ex){
			feature = parant.getFeatureByName(name);
		}
		
		if(feature==null||!(feature instanceof LAttribute))
			throw generateException("getLAttribute(parant,name)",
					"name","Attribute \""+name+"\" has not been defined in LClass \""+parant.getName()+"\"");
		
		return (LAttribute) feature;
	}
	public static LReference getLReference(LClass parant,String name) throws Exception{
		if(parant==null||name==null){
			throw generateException("getLReference(parant,name)","parant|name","Null");
		}
		LStructuralFeature feature = null;
		
		try{
			Integer id = Integer.parseInt(name.trim());
			feature = parant.getFeatureByID(id);
		}catch(Exception ex){
			feature = parant.getFeatureByName(name);
		}
		
		if(feature==null||!(feature instanceof LAttribute))
			throw generateException("getLReference(parant,name)",
					"name","Reference \""+name+"\" has not been defined in LClass \""+parant.getName()+"\"");
		
		return (LReference) feature;
	}
	static List<LAttribute> getLAttributes(LClass parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getLAttributes(parant,child)","parant|child","Null");
		}
		if(child.equals(ATTRIBUTE))return parant.getAttributes();
		else throw generateException("getLAttributes(parant,child)",
				"child","\""+child+"\" does not match required \""+ATTRIBUTE+"\"");
	}
	static List<LReference> getLReferences(LClass parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getLReferences(parant,child)","parant|child","Null");
		}
		if(child.equals(REFERENCE))return parant.getReferences();
		else throw generateException("getLReferences(parant,child)",
				"child","\""+child+"\" does not match required \""+REFERENCE+"\"");
	}
	static List<LClass> getSupers(LClass parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getLSupers(parant,child)","parant|child","Null");
		}
		if(child.equals(SUPER))return parant.getSuperTypes();
		else throw generateException("getSupers(parant,child)",
				"child","\""+child+"\" does not match required \""+SUPER+"\"");
	}
	public static LClass getSuper(LClass parant,String name) throws Exception{
		if(parant==null||name==null){
			throw generateException("getLSupers(parant,name)","parant|name","Null");
		}
		
		LClass type = null;
		List<LClass> supers = parant.getSuperTypes();
		try{
			Integer id = Integer.parseInt(name.trim());
			for(int i=0;i<supers.size();i++)
				if(id==supers.get(i).getClassifierID()){
					type = supers.get(i);break;
				}
		}catch(Exception ex){
			for(int i=0;i<supers.size();i++)
				if(name.equals(supers.get(i).getName())){
					type = supers.get(i);break;
				}
		}
		
		if(type==null)
			throw generateException("getLSupers(parant,name)","name",
					"\""+name+"\" has not been defined in super classes of LClass \""+parant.getName()+"\"");
		return type;
	}
	static List<LStructuralFeature> getFeatures(LClass parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getFeatures(parant,child)","parant|child","Null");
		
		if(child.equals(FEATURE))return parant.getFeatures();
		else{
			throw generateException("getFeatures(parant,child)",
					"child","\""+child+"\" shoud match \""+FEATURE+"\"");
		}
	}
	public static LStructuralFeature getFeature(LClass parant,String name) throws Exception{
		if(parant==null||name==null)
			throw generateException("getFeature(parant,name)","parant|name","Null");
		
		LStructuralFeature feature = null;
		try{
			Integer id = Integer.parseInt(name.trim());
			feature = parant.getFeatureByID(id);
		}catch(Exception ex){
			feature = parant.getFeatureByName(name);
		}
		
		if(feature==null)
			throw generateException("getFeature(parant,name)","name",
					"\""+name+"\" has not been defined in features of LClass \""+parant.getName()+"\"");
		return feature;
	}
	static List<LEnumLiteral> getLiterals(LEnum parant,String child) throws Exception{
		if(parant==null||child==null){
			throw generateException("getLiterals(parant,child)","parant|child","Null");
		}
		
		if(child.equals(LITERAL))return parant.getLiterals();
		else
			throw generateException("getLiterals(parant,child)",
					"child","\""+child+"\" should match \""+LITERAL+"\"");
	}
	public LEnumLiteral getLiteral(LEnum parant,String name) throws Exception{
		if(parant==null||name==null)
			throw generateException("getLiteral(parant,name)","parant|name","Null");
		
		LEnumLiteral literal = null;
		try{
			Integer value = Integer.parseInt(name.trim());
			literal = parant.getLiteralByValue(value);
		}catch(Exception ex){
			literal = parant.getLiteralByName(name);
		}
		
		if(literal==null)
			throw generateException("getLiteral(parant,name)","parant|name",
					"\""+name+"\" has not been defined in LEnum \""+parant.getName()+"\"");
		return literal;
	}
	public static LAttribute getIDAttribute(LClass parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getIDAttribute(parant,child)","parant|child","Null");
		
		if(child.equals(IDATTR))return parant.getIDAttribute();
		else
			throw generateException("getIDAttribute(parant,child)","child",
					"\""+child+"\" should match \""+IDATTR+"\"");
	}
	public static LPackage getContainer(LClassifier parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getContainer(parant,child)","parant|child","Null");
		
		if(child.equals(CONTAINER))return parant.getContainer();
		else
			throw generateException("getContainer(parant,child)","child",
					"\""+child+"\" should match \""+CONTAINER+"\"");
	}
	public static LObject getDefault(LStructuralFeature parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getDefault(parant,child)","parant|child","Null");
		
		if(child.equals(DEFAULT))return parant.getDefaultValue();
		else
			throw generateException("getDefault(parant,child)","child",
					"\""+child+"\" should match \""+DEFAULT+"\"");
	}
	public static LClassifier getType(LStructuralFeature parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getType(parant,child)","parant|child","Null");
		
		if(child.equals(TYPE))return parant.getType();
		else
			throw generateException("getType(parant,child)","child",
					"\""+child+"\" should match \""+TYPE+"\"");
	}
	public LDataType getDataType(LAttribute parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getDataType(parant,child)","parant|child","Null");
		
		if(child.equals(DATATYPE))return parant.getDataType();
		else
			throw generateException("getDataType(parant,child)","child",
					"\""+child+"\" should match \""+DATATYPE+"\"");
	}
	public LClass getClassType(LReference parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getClassType(parant,child)","parant|child","Null");
		
		if(child.equals(CLASSTYPE))return parant.getLClass();
		else
			throw generateException("getClassType(parant,child)","child",
					"\""+child+"\" should match \""+CLASSTYPE+"\"");
	}
	public LReference getOpposite(LReference parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getOpposite(parant,child)","parant|child","Null");
		
		if(child.equals(OPPOSITE))return parant.getOpposite();
		else
			throw generateException("getOpposite(parant,child)","child",
					"\""+child+"\" should match \""+OPPOSITE+"\"");
	}
	public LClassifier getType(LObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getType(parant,child)","parant|child","Null");
		
		if(child.equals(TYPE))return parant.type();
		else
			throw generateException("getType(parant,child)","child",
					"\""+child+"\" should match \""+TYPE+"\"");
	}
	public LDataType getDataType(LDataObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getDataType(parant,child)","parant|child","Null");
		
		if(child.equals(DATATYPE))return parant.getType();
		else
			throw generateException("getDataType(parant,child)","child",
					"\""+child+"\" should match \""+DATATYPE+"\"");
	}
	public LClass getClassType(LClassObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getClassType(parant,child)","parant|child","Null");
		
		if(child.equals(CLASSTYPE))return parant.getType();
		else
			throw generateException("getClassType(parant,child)","child",
					"\""+child+"\" should match \""+CLASSTYPE+"\"");
	}
	public LClassifier getParameterType(LMultipleObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getParameterType(parant,child)","parant|child","Null");
		
		if(child.equals(PARAMETER_TYPE))return parant.getParameterType();
		else
			throw generateException("getParameterType(parant,child)","child",
					"\""+child+"\" should match \""+PARAMETER_TYPE+"\"");
	}
	public Collection<LObject> getU_O(LMultipleObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getU_O(parant,child)","parant|child","Null");
		
		if(child.equals(UNIQUE_ORDER)){
			if(parant.isOrdered()&&parant.isUnique())
				return parant.getAllObjects();
			else
				throw generateException("getU_O(parant,child)","child",
						"Permission Failed");
		}
		else
			throw generateException("getU_O(parant,child)","child",
					"\""+child+"\" should match \""+UNIQUE_ORDER+"\"");
	}
	public Collection<LObject> getIU_O(LMultipleObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getIU_O(parant,child)","parant|child","Null");
		
		if(child.equals(INUNIQUE_ORDER)){
			if(parant.isOrdered()&&!parant.isUnique())
				return parant.getAllObjects();
			else
				throw generateException("getIU_O(parant,child)","child",
						"Permission Failed");
		}
		else
			throw generateException("getIU_O(parant,child)","child",
					"\""+child+"\" should match \""+INUNIQUE_ORDER+"\"");
	}
	public Collection<LObject> getU_IO(LMultipleObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("geU_IO(parant,child)","parant|child","Null");
		
		if(child.equals(UNIQUE_INORDER)){
			if(!parant.isOrdered()&&parant.isUnique())
				return parant.getAllObjects();
			else
				throw generateException("getU_IO(parant,child)","child",
						"Permission Failed");
		}
		else
			throw generateException("getU_IO(parant,child)","child",
					"\""+child+"\" should match \""+UNIQUE_INORDER+"\"");
	}
	public Collection<LObject> getIU_IO(LMultipleObject parant,String child) throws Exception{
		if(parant==null||child==null)
			throw generateException("getIU_IO(parant,child)","parant|child","Null");
		
		if(child.equals(INUNIQUE_INORDER)){
			if(!parant.isOrdered()&&!parant.isUnique())
				return parant.getAllObjects();
			else
				throw generateException("getIU_IO(parant,child)","child",
						"Permission Failed");
		}
		else
			throw generateException("getIU_IO(parant,child)","child",
					"\""+child+"\" should match \""+INUNIQUE_INORDER+"\"");
	}
	
	static Object nextInPackage(LPackage parant,String next) throws Exception{
		if(parant==null||next==null){
			throw generateException("nextInPackage(parant,next)","parant|next","Null");
		}
		
		int s1 = next.indexOf(LEFT);
		int s2 = next.lastIndexOf(RIGHT);
		if(s1<0||s2<0||s1>=s2){
			if(next.equals(PACKAGE))return getSubPackages(parant,PACKAGE);
			if(next.equals(CLASS))return getLClasses(parant,CLASS);
			if(next.equals(ENUM))return getLEnums(parant,ENUM);
			throw generateException("nextInPackage(parant,next)","next","Invalid Argument: \""+next+"\"");
		}
		else{
			String elm = next.substring(s1+1, s2);
			next = next.substring(0, s1);
			if(next.equals(PACKAGE))return getSubPackage(parant,elm);
			if(next.equals(CLASS))return getLClass(parant,elm);
			if(next.equals(ENUM))return getLEnum(parant,elm);
			throw generateException("nextInPackage(parant,next)","next","Invalid Argument: \""+next+"\"");
		}
	}
	static Object nextInClass(LClass parant,String next) throws Exception{
		if(parant==null||next==null){
			throw generateException("nextInClass(parant,next)","parant|next","Null");
		}
		
		int s1 = next.indexOf(LEFT);
		int s2 = next.lastIndexOf(RIGHT);
		if(s1<0||s2<0||s1>=s2){
			if(next.equals(ATTRIBUTE))return getLAttributes(parant,ATTRIBUTE);
			if(next.equals(REFERENCE))return getLReferences(parant,REFERENCE);
			if(next.equals(SUPER))return getSupers(parant,SUPER);
			if(next.equals(FEATURE))return getFeatures(parant,FEATURE);
			if(next.equals(IDATTR))return getIDAttribute(parant,IDATTR);
			if(next.equals(CONTAINER))return getContainer(parant,CONTAINER);
			throw generateException("nextInClass(parant,next)","next","Invalid Argument: \""+next+"\"");
		}
		else{
			String elm = next.substring(s1+1, s2);
			next = next.substring(0, s1);
			if(next.equals(ATTRIBUTE))return getLAttribute(parant,elm);
			if(next.equals(REFERENCE))return getLReference(parant,elm);
			if(next.equals(SUPER))return getSuper(parant,elm);
			if(next.equals(FEATURE))return getFeature(parant,elm);
			//if(next.equals(IDATTR))return getIDAttribute(parant,IDATTR);
			//if(next.equals(CONTAINER))return getContainer(parant,CONTAINER);
			throw generateException("nextInClass(parant,next)","next","Invalid Argument: \""+next+"\"");
		}
	}
	
}
