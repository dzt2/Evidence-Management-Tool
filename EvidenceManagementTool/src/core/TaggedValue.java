package core;

public interface TaggedValue extends UtilityElement {
	
	public static final String TYPE_NAME = "core.TaggedValue";
	public static final String KEY_VALUE = "value";
	public static final String KEY_KEY = "key";
	
	
	public String getValue();
	
	public void setValue(String value);
	
	public String getKey();
	
	public void setKey(String value);
	
}
