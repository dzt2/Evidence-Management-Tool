package cn.edu.buaa.sei.emt.safe;

public interface Assertion extends SNode {
	
	public static final String TYPE_NAME = "safe.Assertion";
	public static final String KEY_NAME = "name";
	public static final String KEY_RESULT = "result";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_ASSURED_RESULT = "assured_result";
	
	
	public String getStatement();
	
	public void setStatement(String value);
	
	public boolean getResult();
	
	public void setResult(boolean value);
	
	public boolean getAssured_result();
	
	public void setAssured_result(boolean value);
	
}
