package cn.edu.buaa.sei.emt.safe;

public interface ContextOf extends SRelation {
	
	public static final String TYPE_NAME = "safe.ContextOf";
	public static final String KEY_CONTEXT = "context";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public Assertion getObjective();
	
	public void setObjective(Assertion value);
	
	public Context getContext();
	
	public void setContext(Context value);
	
}
