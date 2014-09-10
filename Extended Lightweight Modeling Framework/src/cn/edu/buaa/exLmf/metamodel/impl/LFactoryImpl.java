package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LFactory;
import cn.edu.buaa.exLmf.metamodel.LPackage;

public class LFactoryImpl extends LModelElementImpl implements LFactory{
	public static final String TRUE_CODE = "true";
	public static final String FALSE_CODE = "false";
	public static final LDataObjectImpl TRUE,FALSE;
	
	static{
		TRUE = new LDataObjectImpl(LPrimitiveTypeImpl.BOOL);
		FALSE = new LDataObjectImpl(LPrimitiveTypeImpl.BOOL);
		TRUE.val=true;
		FALSE.val=false;
	}
	
	Boolean isLight=false;
	
	public LPackage ePackage;
	public LFactoryImpl(LPackage p,Boolean isLight){super();this.ePackage=p;this.isLight=isLight;}
	@Override
	public LPackage getContainer() {return this.ePackage;}

	@Override
	public LClassObject create(LClass type) {
		if(type==null){
			try {
				throw this.getException("create(type)", "type", "Null");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		if(!this.ePackage.containType(type)){
			try {
				throw this.getException("create(type)", "type", "Undefined in Package");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(type.isAbstract()){
			try {
				throw this.getException("create(type)", "type", "Abstract type \""+type.getName()+"\" cannot be instantiated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(this.isLight)
			return new SimpleLClassObject(type);
		else
			return new LClassObjectImpl(type);
	}
	@Override
	public LDataObject create(LDataType type, String code) {
		if(type==null){
			try {
				throw this.getException("create(type, code)", "type", "Null");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		if(code==null){
			try {
				throw this.getException("create(type, code)", "code", "Null");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		if(type==LPrimitiveTypeImpl.BOOL){return this.createBool(code);}
		else if(type==LPrimitiveTypeImpl.INT){return this.createInteger(code);}
		else if(type==LPrimitiveTypeImpl.LONG){return this.createLong(code);}
		else if(type==LPrimitiveTypeImpl.FLOAT){return this.createFloat(code);}
		else if(type==LPrimitiveTypeImpl.DOUBLE){return this.createDouble(code);}
		else if(type==LPrimitiveTypeImpl.STRING){return this.createString(code);}
		else if(type instanceof LEnum){return this.createLiteral((LEnum) type, code);}
		else{
			try {
				throw this.getException("create(type, code)", "type", type.getName()+" cannot be decoded.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	LDataObject createBool(String code){
		if(code==null){
			return null;
		}
		if(TRUE_CODE.equals(code.trim()))
			return TRUE;
		else if(FALSE_CODE.equals(code.trim()))
			return FALSE;
		else{
			try {
				throw this.getException("createBool(type,code)", "code", "\""+code.trim()+"\" is invalid for Boolean");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	LDataObject createInteger(String code){
		if(code==null)return null;
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.INT);
		try{
			Integer i = Integer.parseInt(code.trim());
			val.val=i;
		}
		catch(Exception ex){
			try {
				throw this.getException("createInteger(code)", "code", "\""+code.trim()+"\" is invalid integer code");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return val;
	}
	LDataObject createLong(String code){
		if(code==null)return null;
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.LONG);
		try{
			Long i = Long.parseLong(code.trim());
			val.val=i;
		}
		catch(Exception ex){
			try {
				throw this.getException("createLong(code)", "code", "\""+code.trim()+"\" is invalid Long code");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return val;
	}
	LDataObject createFloat(String code){
		if(code==null)return null;
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.FLOAT);
		try{
			Float i = Float.parseFloat(code.trim());
			val.val=i;
		}
		catch(Exception ex){
			try {
				throw this.getException("createFloat(code)", "code", "\""+code.trim()+"\" is invalid Float code");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return val;
	}
	LDataObject createDouble(String code){
		if(code==null)return null;
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.DOUBLE);
		try{
			Double i = Double.parseDouble(code.trim());
			val.val=i;
		}
		catch(Exception ex){
			try {
				throw this.getException("createDouble(code)", "code", "\""+code.trim()+"\" is invalid Double code");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return val;
	}
	LDataObject createString(String code){
		if(code==null)return null;
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.STRING);
		val.val=code;
		return val;
	}
	LDataObject createLiteral(LEnum type,String name){
		if(type==null||name==null)return null;
		
		LEnumLiteral literal = type.getLiteralByName(name);
		LDataObjectImpl val = new LDataObjectImpl(type);
		val.val=literal;
		return val;
	}
}
