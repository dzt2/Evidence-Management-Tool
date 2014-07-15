package cn.edu.buaa.sei.emt.safe;

public interface XMLEvidence extends Evidence {
	
	public static final String TYPE_NAME = "evidence.XMLEvidence";
	public static final String KEY_XML_URL = "xml_url";
	public static final String KEY_NAME = "name";
	
	
	public String getXml_url();
	
	public void setXml_url(String value);
	
}
