package cn.edu.buaa.sei.emt.safe;

public interface ChallengeByClaim extends SRelation {
	
	public static final String TYPE_NAME = "safe.ChallengeByClaim";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_PREMISE = "premise";
	public static final String KEY_CONCLUSION = "conclusion";
	
	
	public Claim getPremise();
	
	public void setPremise(Claim value);
	
	public Claim getConclusion();
	
	public void setConclusion(Claim value);
	
}
