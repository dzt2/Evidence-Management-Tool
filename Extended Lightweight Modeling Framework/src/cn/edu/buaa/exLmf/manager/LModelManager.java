package cn.edu.buaa.exLmf.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;
import cn.edu.buaa.exLmf.metamodel.LStructuralFeature;
import cn.edu.buaa.exLmf.metamodel.impl.LAttributeImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LClassImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LEnumImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LEnumLiteralImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LMFException;
import cn.edu.buaa.exLmf.metamodel.impl.LPackageImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LReferenceImpl;

public class LModelManager {
	public static final String nsURI = "edu.cn.buaa.sei.exLmf";
	public static final String prefix = "";
	
	public static final int UNIQUE_SET = 0;
	public static final int UNIQUE_LST = 1;
	public static final int INUNIQUE_SET = 2;
	public static final int INUNIQUE_LST = 3;
	
	int id = 0;
	Set<Integer> id_space = new HashSet<Integer>();
	String name;
	
	public LModelManager(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getException(String func,String arg,String reason){
		return LMFException.create("Model_Manager "+this.name, "LMFCreator", func, arg, reason);
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
	void releaseID(int id){
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
		
		LClass type = new LClassImpl(name.trim(),p);
		type.setDefaultValue(null);
		type.setInstanceName(name.trim());
		type.setClassifierID(this.generateID());
		type.setAbstract(false);
		type.setFinal(false);
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
		
		LClass type = new LClassImpl(name.trim(),p);
		type.setDefaultValue(null);
		type.setInstanceName(ins.trim());
		type.setClassifierID(this.generateID());
		type.setAbstract(false);
		type.setFinal(false);
		p.addType(type);
		
		return type;
	}

	public LClass createAbstractClass(LPackage p,String name){
		if(p==null){
			try {
				throw getException("createAbstractClass(p,name)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createAbstractClass(p,name)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass type = new LClassImpl(name.trim(),p);
		type.setDefaultValue(null);
		type.setInstanceName(name.trim());
		type.setClassifierID(this.generateID());
		type.setAbstract(true);
		type.setFinal(false);
		p.addType(type);
		
		return type;
	}
	public LClass createAbstractClass(LPackage p,String name,String ins){
		if(p==null){
			try {
				throw getException("createAbstractClass(p,name,ins)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createAbstractClass(p,name,ins)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(ins==null||ins.trim().length()==0){
			try {
				throw getException("createAbstractClass(p,name,ins)","ins","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass type = new LClassImpl(name.trim(),p);
		type.setDefaultValue(null);
		type.setInstanceName(ins.trim());
		type.setClassifierID(this.generateID());
		type.setAbstract(true);
		type.setFinal(false);
		p.addType(type);
		
		return type;
	}
	
	public LClass createFinalClass(LPackage p,String name){
		if(p==null){
			try {
				throw getException("createFinalClass(p,name)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createFinalClass(p,name)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass type = new LClassImpl(name.trim(),p);
		type.setDefaultValue(null);
		type.setInstanceName(name.trim());
		type.setClassifierID(this.generateID());
		type.setAbstract(true);
		type.setFinal(false);
		p.addType(type);
		
		return type;
	}
	public LClass createFinalClass(LPackage p,String name,String ins){
		if(p==null){
			try {
				throw getException("createFinalClass(p,name,ins)","p","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(name==null||name.trim().length()==0){
			try {
				throw getException("createFinalClass(p,name,ins)","name","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(ins==null||ins.trim().length()==0){
			try {
				throw getException("createFinalClass(p,name,ins)","ins","Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass type = new LClassImpl(name.trim(),p);
		type.setDefaultValue(null);
		type.setInstanceName(ins.trim());
		type.setClassifierID(this.generateID());
		type.setAbstract(false);
		type.setFinal(true);
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
		
		LEnum e = new LEnumImpl(name.trim(),p);
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
		
		LEnum e = new LEnumImpl(name.trim(),p);
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
		
		container.addAttribute(attr);
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
		
		attr.setChangable(false);
		attr.setDataType(type);
		attr.setDefaultValue(type.getDefaultValue());
		container.addAttribute(attr);
		
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
		container.addAttribute(attr);
		
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
		
		container.addReference(ref);
		
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
		ref.setChangable(false);
		ref.setContainment(false);
		ref.setDefaultValue(type.getDefaultValue());
		ref.setLClass(type);
		ref.setLowerBound(0);
		ref.setUpperBound(1);
		ref.setOrdered(true);
		ref.setUnique(false);
		ref.setOpposite(null);
		container.addReference(ref);
		
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
		
		ref.setChangable(false);
		ref.setContainment(false);
		ref.setDefaultValue(type.getDefaultValue());
		ref.setLClass(type);
		ref.setOpposite(null);
		container.addReference(ref);
		
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
		container.addLiteral(l);
		
		return l;
	}
	public LEnumLiteral createLiteral(LEnum container,String name,String literal,int value){
		if(container==null||name==null||name.trim().length()==0||literal==null||literal.trim().length()==0){
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
		l.setLiteral(literal.trim());
		l.setLowerBound(1);l.setUpperBound(1);
		l.setOrdered(false);l.setUnique(true);
		l.setValue(value);
		container.addLiteral(l);
		
		return l;
	}

	public void removeLAttribute(LAttribute attr){
		if(attr==null||!this.id_space.contains(attr.getFeatureID())){
			try {
				throw this.getException("removeAttribute(attr)", "attr", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		LClass container = (LClass) attr.getContainer();
		if(container==null){
			try {
				throw this.getException("removeAttribute(attr)", "attr", "UnIncluded");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		container.removeAttribute(attr);
		
		this.releaseID(attr.getFeatureID());
	}
	public void removeLReference(LReference ref){
		if(ref==null||!this.id_space.contains(ref.getFeatureID())){
			try {
				throw this.getException("removeLReference(ref)", "ref", "Undefined");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		LClass container = (LClass) ref.getContainer();
		if(container==null){
			try {
				throw this.getException("removeLReference(ref)", "ref", "UnIncluded");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		container.removeReference(ref);
		if(ref.getOpposite()!=null)ref.getOpposite().release_opposite();
		this.releaseID(ref.getFeatureID());
	}
	public void removeLiteral(LEnumLiteral literal){
		if(literal==null||!this.id_space.contains(literal.getFeatureID())){
			try {
				throw this.getException("removeLiteral(literal)", "literal", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		LEnum container = (LEnum) literal.getContainer();
		if(container==null){
			try {
				throw this.getException("removeLiteral(literal)", "literal", "UnIncluded");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		container.removeLiteral(literal);
		
		this.releaseID(literal.getFeatureID());
	}
	public void removeLEnum(LEnum e){
		if(e==null||!this.id_space.contains(e.getClassifierID())){
			try {
				throw this.getException("removeLEnum(e)", "e", "Undefined");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		LPackage container = e.getContainer();
		if(container==null){
			try {
				throw this.getException("removeLEnum(e)", "e", "UnIncluded");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		container.removeType(e);
		
		List<LEnumLiteral> literals = e.getLiterals();
		for(int i=0;i<literals.size();i++)
			this.removeLiteral(literals.get(i));
		
		this.releaseID(e.getClassifierID());
	}
	public void removeLClass(LClass type){
		if(type==null||!this.id_space.contains(type.getClassifierID())){
			try {
				throw this.getException("removeLClass(type)", "type", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		LPackage container = type.getContainer();
		if(container==null){
			try {
				throw this.getException("removeLClass(type)", "type", "UnIncluded");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		container.removeType(type);
		
		List<LStructuralFeature> features = type.getFeatures();
		for(int i=0;i<features.size();i++){
			LStructuralFeature fi = features.get(i);
			if(fi instanceof LReference){
				this.removeLReference((LReference) fi);
			}
			else if(fi instanceof LAttribute)
				this.removeLAttribute((LAttribute) fi);
			else{
				try {
					throw this.getException("removeLClass(type)", "type.feature["+i+"]", "UnKnown-Type Features in Class: "+fi.getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		
		this.releaseID(type.getClassifierID());
	}

	public LAttribute createIDAttribute(LClass container,String name,LDataType type){
		if(container==null||name==null||name.trim().length()==0||type==null){
			try {
				throw this.getException("createIDAttribute(container,name,type)", "container|name|type", "Null");
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
		container.setIDAttribute(attr);
		
		return attr;
	}
	public LAttribute createIDAttribute(LClass container,String name,LDataType type,Boolean constant){
		if(container==null||name==null||name.trim().length()==0||type==null||constant==null){
			try {
				throw this.getException("createIDAttribute(container,name,type,constant)", "container|name|type|constant", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LAttribute attr = new LAttributeImpl(this.generateID(),name.trim(),container);
		attr.setChangable(!constant);
		attr.setDataType(type);
		attr.setDefaultValue(type.getDefaultValue());
		attr.setLowerBound(0);
		attr.setUpperBound(1);
		attr.setOrdered(true);
		attr.setUnique(false);
		container.setIDAttribute(attr);
		
		return attr;
	}
}
