package cn.edu.buaa.sei.emt.safe;

public interface XMLEvidenceSuggestion extends EvidenceSuggestion {
	
	public static final String TYPE_NAME = "evidence.XMLEvidenceSuggestion";
	public static final String KEY_NAME = "name";
	public static final String KEY_SCHEMA_URL = "schema_url";
	
	
	public String getSchema_url();
	
	public void setSchema_url(String value);
	
}
