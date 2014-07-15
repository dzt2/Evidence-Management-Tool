package cn.edu.buaa.sei.emt.safe;

public interface AssumedBy extends SRelation {
	
	public static final String TYPE_NAME = "safe.AssumedBy";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_ASSUMPTION = "assumption";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public Assertion getObjective();
	
	public void setObjective(Assertion value);
	
	public Assumption getAssumption();
	
	public void setAssumption(Assumption value);
	
}
