package core;

public interface Annotation extends UtilityElement {
	
	public static final String TYPE_NAME = "core.Annotation";
	public static final String KEY_CONTENT = "content";
	
	
	public String getContent();
	
	public void setContent(String value);
	
}
