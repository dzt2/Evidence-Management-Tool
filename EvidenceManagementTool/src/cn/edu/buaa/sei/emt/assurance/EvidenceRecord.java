package cn.edu.buaa.sei.emt.assurance;

public interface EvidenceRecord extends BasicEvidence {
	
	public static final String TYPE_NAME = "evidence.EvidenceRecord";
	public static final String KEY_INTVALUE = "intValue";
	public static final String KEY_PROPERTIES = "properties";
	public static final String KEY_NAME = "name";
	public static final String KEY_TYPE = "type";
	public static final String KEY_DOUBLEVALUE = "doubleValue";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_BOOLVALUE = "boolValue";
	public static final String KEY_FLOATVALUE = "floatValue";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_STRINGVALUE = "stringValue";
	
	
	public String getName();
	
	public void setName(String value);
	
	public String getStringValue();
	
	public void setStringValue(String value);
	
	public double getDoubleValue();
	
	public void setDoubleValue(double value);
	
	public float getFloatValue();
	
	public void setFloatValue(float value);
	
	public boolean getBoolValue();
	
	public void setBoolValue(boolean value);
	
	public int getType();
	
	public void setType(int value);
	
	public int getIntValue();
	
	public void setIntValue(int value);
	
}
