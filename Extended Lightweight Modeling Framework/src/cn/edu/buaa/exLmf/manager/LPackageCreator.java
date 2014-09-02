package cn.edu.buaa.exLmf.manager;

import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;
import cn.edu.buaa.exLmf.metamodel.impl.LAttributeImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LClassImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LEnumImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LEnumLiteralImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LMFException;
import cn.edu.buaa.exLmf.metamodel.impl.LPackageImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LReferenceImpl;

public class LPackageCreator {
	
	public static final String nsURI = "edu.cn.buaa.sei.exLmf";
	public static final String prefix = "";
	
	public static final int UNIQUE_SET = 0;
	public static final int UNIQUE_LST = 1;
	public static final int INUNIQUE_SET = 2;
	public static final int INUNIQUE_LST = 3;
	
	int id = 0;
	Set<Integer> id_space = new HashSet<Integer>();
	String name;
	
	public LPackageCreator(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getException(String func,String arg,String reason){
		return LMFException.create("Manager_Package", "LMFCreator", func, arg, reason);
	}
	int nextID(){
		if(id<0)id=0;
		return id++;
	}
	int generateID(){
		int initial = id;
		while(this.id_space.contains(id)){
			nextID();
			if(id==initial){
				try {
					throw this.getException("generateID()", ""+id, "ID space has been used out");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		this.id_space.add(id);
		return id;
	}
	void releaseID(){
		if(this.id_space.contains(id))
			this.id_space.remove(id);
	}
	
	
	/*
	 *	Manager Functions 
	 */
	public LPackage createPackage(String name){
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createPackage(name)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return new LPackageImpl(name.trim(),nsURI,prefix);
	}
	public LPackage createPackage(String name,String uri,String prefix){
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createPackage(name,uri,prefix)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(uri==null){
			try {
				throw getException("createPackage(name,uri,prefix)","uri","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(prefix==null){
			try {
				throw getException("createPackage(name,uri,prefix)","prefix","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return new LPackageImpl(name.trim(),uri.trim(),prefix.trim());
	}

	public LClass createClass(LPackage p,String name){
		if(p==null){
			try {
				throw getException("createClass(p,name)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createClass(p,name)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass type = new LClassImpl(name.trim());
		type.setDefaultValue(null);
		type.setInstanceName(name.trim());
		type.setClassifierID(this.generateID());
		p.addType(type);
		
		return type;
	}
	public LClass createClass(LPackage p,String name,String ins){
		if(p==null){
			try {
				throw getException("createClass(p,name,ins)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createClass(p,name,ins)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(ins==null||ins.trim().length()==0){
			try {
				throw getException("createClass(p,name,ins)","ins","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass type = new LClassImpl(name.trim());
		type.setDefaultValue(null);
		type.setInstanceName(ins.trim());
		type.setClassifierID(this.generateID());
		p.addType(type);
		
		return type;
	}

	public LEnum createEnum(LPackage p,String name){
		if(p==null){
			try {
				throw getException("createEnum(p,name)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createEnum(p,name)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LEnum e = new LEnumImpl(name.trim());
		e.setDefaultValue(null);
		e.setInstanceName(name.trim());
		e.setClassifierID(this.generateID());
		p.addType(e);
		
		return e;
	}
	public LEnum createEnum(LPackage p,String name,String ins){
		if(p==null){
			try {
				throw getException("createEnum(p,name,ins)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createEnum(p,name,ins)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(ins==null||ins.trim().length()==0){
			try {
				throw getException("createEnum(p,name,ins)","ins","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LEnum e = new LEnumImpl(name.trim());
		e.setDefaultValue(null);
		e.setInstanceName(ins.trim());
		e.setClassifierID(this.generateID());
		p.addType(e);
		return e;
	}
	
	public LAttribute createAttribute(LClass container,String name,LDataType type){
		if(container==null||name==null||name.trim().length()==0||type==null){
			try {
				throw this.getException("createAttribute(container,name,type)", "container|name|type", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LAttribute attr = new LAttributeImpl(this.generateID(),name.trim(),container);
		attr.setChangable(true);
		attr.setDataType(type);
		attr.setDefaultValue(type.getDefaultValue());
		attr.setLowerBound(0);
		attr.setUpperBound(1);
		attr.setOrdered(true);
		attr.setUnique(false);
		
		return attr;
	}
	public LAttribute createMultipleAttribute(LClass container,String name,LDataType type,int lower,int upper,int multiple_type){
		LAttribute attr = this.createAttribute(container, name, type);
		if(attr==null)return null;
		if(lower<0){
			try {
				throw this.getException("createMultipleAttribute(container,name,type,lower,upper,multiple_type)",
						"lower", "Invalid LowerBound: "+lower);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(upper<0&&upper!=LMultipleObject.UNBOUNDED){
			try {
				throw this.getException("createMultipleAttribute(container,name,type,lower,upper,multiple_type)",
						"upper", "Invalid UpperBound: "+upper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(upper!=LMultipleObject.UNBOUNDED&&upper<lower){
			try {
				throw this.getException("createMultipleAttribute(container,name,type,lower,upper,multiple_type)",
						"upper-lower", "Invalid Range: <"+lower+" --> "+upper+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		attr.setLowerBound(lower);attr.setUpperBound(upper);
		
		switch(multiple_type){
		case UNIQUE_SET:attr.setUnique(true);attr.setOrdered(false);break;
		case UNIQUE_LST:attr.setUnique(true);attr.setOrdered(true);break;
		case INUNIQUE_SET:attr.setUnique(false);attr.setOrdered(false);break;
		case INUNIQUE_LST:attr.setUnique(false);attr.setOrdered(true);break;
		default:{
			try {
				throw this.getException("createMultipleAttribute(container,name,type,lower,upper,multiple_type)",
						"multiple_type", "Invalid multiple_type: "+multiple_type);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		}
		
		return attr;
	}
	public LAttribute createConstantAttribute(LClass container,String name,LDataType type){
		if(container==null||name==null||name.trim().length()==0||type==null){
			try {
				throw this.getException("createConstantAttribute(container,name,type)", "container|name|type", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LAttribute attr = new LAttributeImpl(this.generateID(),name.trim(),container);
		attr.setChangable(false);
		attr.setDataType(type);
		attr.setDefaultValue(type.getDefaultValue());
		attr.setLowerBound(0);
		attr.setUpperBound(1);
		attr.setOrdered(true);
		attr.setUnique(false);
		
		return attr;
	}
	
	public LReference createReference(LClass container,String name,LClass type){
		if(container==null||name==null||name.trim().length()==0||type==null){
			try {
				throw this.getException("createReference(container,name,type)", "container|name|type", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LReference ref = new LReferenceImpl(this.generateID(),name.trim(),container);
		ref.setChangable(true);
		ref.setContainment(false);
		ref.setDefaultValue(type.getDefaultValue());
		ref.setLClass(type);
		ref.setLowerBound(0);
		ref.setUpperBound(1);
		ref.setOrdered(true);
		ref.setUnique(false);
		ref.setOpposite(null);
		
		return ref;
	}
	public LReference createConstantReference(LClass container,String name,LClass type){
		if(container==null||name==null||name.trim().length()==0||type==null){
			try {
				throw this.getException("createConstantReference(container,name,type)", "container|name|type", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LReference ref = new LReferenceImpl(this.generateID(),name.trim(),container);
		ref.setChangable(true);
		ref.setContainment(false);
		ref.setDefaultValue(type.getDefaultValue());
		ref.setLClass(type);
		ref.setLowerBound(0);
		ref.setUpperBound(1);
		ref.setOrdered(true);
		ref.setUnique(false);
		ref.setOpposite(null);
		
		return ref;
	}
	public LReference createMultipleReference(LClass container,String name,LClass type,int lower,int upper,int multiple_type){
		LReference ref = this.createReference(container, name, type);
		if(ref==null)return null;
		if(lower<0){
			try {
				throw this.getException("createMultipleReference(container,name,type,lower,upper,multiple_type)",
						"lower", "Invalid LowerBound: "+lower);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(upper<0&&upper!=LMultipleObject.UNBOUNDED){
			try {
				throw this.getException("createMultipleReference(container,name,type,lower,upper,multiple_type)",
						"upper", "Invalid UpperBound: "+upper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(upper!=LMultipleObject.UNBOUNDED&&upper<lower){
			try {
				throw this.getException("createMultipleReference(container,name,type,lower,upper,multiple_type)",
						"upper-lower", "Invalid Range: <"+lower+" --> "+upper+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		ref.setLowerBound(lower);ref.setUpperBound(upper);
		
		switch(multiple_type){
		case UNIQUE_SET:ref.setUnique(true);ref.setOrdered(false);break;
		case UNIQUE_LST:ref.setUnique(true);ref.setOrdered(true);break;
		case INUNIQUE_SET:ref.setUnique(false);ref.setOrdered(false);break;
		case INUNIQUE_LST:ref.setUnique(false);ref.setOrdered(true);break;
		default:{
			try {
				throw this.getException("createMultipleReference(container,name,type,lower,upper,multiple_type)",
						"multiple_type", "Invalid multiple_type: "+multiple_type);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		}
		
		return ref;
		
	}
	
	public LEnumLiteral createLiteral(LEnum container,String name,int value){
		if(container==null||name==null||name.trim().length()==0){
			try {
				throw this.getException("createLiteral(container,name,Null)", "container|name", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LEnumLiteral l = new LEnumLiteralImpl(this.generateID(),name.trim(),container);
		l.setChangable(false);
		l.setLiteral(name.trim());
		l.setLowerBound(1);l.setUpperBound(1);
		l.setOrdered(false);l.setUnique(true);
		l.setValue(value);
		
		return l;
	}
}
