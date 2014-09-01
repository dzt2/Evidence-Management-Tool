package cn.edu.buaa.exLmf.metamodel.impl;

import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LFactory;
import cn.edu.buaa.exLmf.metamodel.LObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;

public class LFactoryImpl extends LModelElementImpl implements LFactory{
	
	public static final String TRUE_CODE = "true";
	public static final String FALSE_CODE = "false";
	
	
	public LPackage ePackage;
	public LFactoryImpl(LPackage p){super();this.ePackage=p;}
	@Override
	public LPackage getContainer() {return this.ePackage;}

	@Override
	public LObject create(LClass type) {
		if(type==null){
			try {
				throw this.getException("create(type)", "type", "Null");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		return new LClassObjectImpl(type);
	}
	@Override
	public LObject create(LDataType type, String code) {
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
	
	LObject createBool(String code){
		if(code==null){
			return null;
		}
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.BOOL);
		if(TRUE_CODE.equals(code.trim()))
			val.val=true;
		else if(FALSE_CODE.equals(code.trim()))
			val.val=false;
		else{
			try {
				throw this.getException("createBool(type,code)", "code", "\""+code.trim()+"\" is invalid for Boolean");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		return val;
	}
	LObject createInteger(String code){
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
	LObject createLong(String code){
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
	LObject createFloat(String code){
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
	LObject createDouble(String code){
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
	LObject createString(String code){
		if(code==null)return null;
		
		LDataObjectImpl val = new LDataObjectImpl(LPrimitiveTypeImpl.STRING);
		val.val=code;
		return val;
	}
	LObject createLiteral(LEnum type,String name){
		if(type==null||name==null)return null;
		
		LEnumLiteral literal = type.getLiteralByName(name);
		LDataObjectImpl val = new LDataObjectImpl(type);
		val.val=literal;
		return val;
	}
	
	
}
