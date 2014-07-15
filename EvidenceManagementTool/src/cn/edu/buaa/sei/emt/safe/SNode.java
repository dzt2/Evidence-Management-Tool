package cn.edu.buaa.sei.emt.safe;

public interface SNode extends SElement {
	
	public static final String TYPE_NAME = "safe.SNode";
	public static final String KEY_NAME = "name";
	
	
	public String getName();
	
	public void setName(String value);
	
}
