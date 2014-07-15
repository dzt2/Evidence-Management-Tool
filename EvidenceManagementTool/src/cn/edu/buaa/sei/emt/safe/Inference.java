package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface Inference extends Assertion {
	
	public static final String TYPE_NAME = "safe.Inference";
	public static final String KEY_NAME = "name";
	public static final String KEY_RESULT = "result";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_ASSURED_RESULT = "assured_result";
	public static final String KEY_PREMISE = "premise";
	public static final String KEY_RATIONALE = "rationale";
	public static final String KEY_CONCLUSION = "conclusion";
	
	
	public List<Assertion> getPremise();
	
	public Assertion getConclusion();
	
	public void setConclusion(Assertion value);
	
	public String getRationale();
	
	public void setRationale(String value);
	
}
