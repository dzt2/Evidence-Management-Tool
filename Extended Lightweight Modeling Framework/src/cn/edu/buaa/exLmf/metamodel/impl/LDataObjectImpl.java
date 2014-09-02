package cn.edu.buaa.exLmf.metamodel.impl;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;

public class LDataObjectImpl extends LObjectImpl implements LDataObject{
	Object val;
	
	public LDataObjectImpl(LDataType type) {
		super(type);
	}

	@Override
	public LDataType getType() {return (LDataType) this.type;}
	
	@Override
	public Boolean boolVal() {
		if(this.type==LPrimitiveTypeImpl.BOOL)
			return (Boolean) this.val;
		else{
			try {
				throw this.getException("boolVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as Boolean");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public Integer integerVal() {
		if(this.type==LPrimitiveTypeImpl.INT)
			return (Integer) this.val;
		else{
			try {
				throw this.getException("integerVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as Integer");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public Long longVal() {
		if(this.type==LPrimitiveTypeImpl.LONG)
			return (Long) this.val;
		else{
			try {
				throw this.getException("longVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as Long");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public Float floatVal() {
		if(this.type==LPrimitiveTypeImpl.FLOAT)
			return (Float) this.val;
		else{
			try {
				throw this.getException("floatVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as Float");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public Double doubleVal() {
		if(this.type==LPrimitiveTypeImpl.DOUBLE)
			return (Double) this.val;
		else{
			try {
				throw this.getException("doubleVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as Double");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public String stringVal() {
		if(this.type==LPrimitiveTypeImpl.STRING)
			return (String) this.val;
		else{
			try {
				throw this.getException("stringVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as String");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public LEnumLiteral literalVal() {
		if(this.type instanceof LEnum)
			return (LEnumLiteral) this.val;
		else{
			try {
				throw this.getException("literalVal()", "type",
						"Try to get instance type <"+this.type.getName()+"> as Enum");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	
	@Override
	public Object getValue() {
		return this.val;
	}
	@Override
	public void setValue(Object val) {
		if(val==null){
			this.val=null;
			return;
		}
		
		if(val instanceof Boolean)
			this.setBool((Boolean) val);
		else if(val instanceof Integer)
			this.setInt((Integer) val);
		else if(val instanceof Long)
			this.setLong((Long) val);
		else if(val instanceof Float)
			this.setFloat((Float) val);
		else if(val instanceof Double)
			this.setDouble((Double) val);
		else if(val instanceof String)
			this.setString((String) val);
		else if(val instanceof LEnumLiteral)
			this.setLiteral((LEnumLiteral) val);
		else{
			try {
				throw this.getException("setValue(val)", "val", 
						val.getClass().getName()+" is not primitive input data type.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void setBool(Boolean val) {
		if(this.type==LPrimitiveTypeImpl.BOOL)
			this.val=val;
		else{
			try {
				throw this.getException("setBool(val)", "this.val", this.type.getName() + " does not match!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setInt(Integer val) {
		if(this.type==LPrimitiveTypeImpl.INT)
			this.val=val;
		else{
			try {
				throw this.getException("setInt(val)", "this.val", this.type.getName() + " does not match!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setLong(Long val) {
		if(this.type==LPrimitiveTypeImpl.LONG)
			this.val=val;
		else{
			try {
				throw this.getException("setLong(val)", "this.val", this.type.getName() + " does not match!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setFloat(Float val) {
		if(this.type==LPrimitiveTypeImpl.FLOAT)
			this.val=val;
		else{
			try {
				throw this.getException("setFloat(val)", "this.val", this.type.getName() + " does not match!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setDouble(Double val) {
		if(this.type==LPrimitiveTypeImpl.DOUBLE)
			this.val=val;
		else{
			try {
				throw this.getException("setDouble(val)", "this.val", this.type.getName() + " does not match!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setString(String val) {
		if(this.type==LPrimitiveTypeImpl.STRING)
			this.val=val;
		else{
			try {
				throw this.getException("setString(val)", "this.val", this.type.getName() + " does not match!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setLiteral(LEnumLiteral literal) {
		if(literal==null){
			this.val=null;
			return;
		}
		
		if(this.type instanceof LEnum){
			if(((LEnum) type).containLiteral(literal))
				this.val=literal;
			else{
				try {
					throw this.getException("setLiteral(val)", "this.val", 
							literal.getName()+" is not defined in Enumeration <"+type.getName()+">");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else{
			try {
				throw this.getException("setLiteral(val)", "this.val", this.type.getName() + " is not Enumeration!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
