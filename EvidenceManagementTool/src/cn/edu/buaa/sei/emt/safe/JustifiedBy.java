package cn.edu.buaa.sei.emt.safe;

public interface JustifiedBy extends SRelation {
	
	public static final String TYPE_NAME = "safe.JustifiedBy";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_JUSTIFICATION = "justification";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public Assertion getObjective();
	
	public void setObjective(Assertion value);
	
	public Justification getJustification();
	
	public void setJustification(Justification value);
	
}
