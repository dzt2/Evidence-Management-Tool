package cn.edu.buaa.exLmf.metamodel;

public interface LDataObject extends LObject{
	public LDataType getType();
	
	public Object getValue();
	public void setValue(Object val);
	
	public Boolean boolVal();
	public Integer integerVal();
	public Long longVal();
	public Float floatVal();
	public Double doubleVal();
	public String stringVal();
	public LEnumLiteral literalVal();
	
	public void setBool(Boolean val);
	public void setInt(Integer val);
	public void setLong(Long val);
	public void setFloat(Float val);
	public void setDouble(Double val);
	public void setString(String val);
	public void setLiteral(LEnumLiteral literal);
}
