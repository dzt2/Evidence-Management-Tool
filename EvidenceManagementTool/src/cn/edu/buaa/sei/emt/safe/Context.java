package cn.edu.buaa.sei.emt.safe;

public interface Context extends SNode {
	
	public static final String TYPE_NAME = "safe.Context";
	public static final String KEY_NAME = "name";
	public static final String KEY_CONTEXT = "context";
	
	
	public String getContext();
	
	public void setContext(String value);
	
}
