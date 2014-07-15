package cn.edu.buaa.sei.emt.safe;

public interface UndevelopedClaim extends Claim {
	
	public static final String TYPE_NAME = "safe.UndevelopedClaim";
	public static final String KEY_CASE = "case";
	public static final String KEY_NAME = "name";
	public static final String KEY_RESULT = "result";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_ASSURED_RESULT = "assured_result";
	
	
	public SafetyCase getCase();
	
	public void setCase(SafetyCase value);
	
}
