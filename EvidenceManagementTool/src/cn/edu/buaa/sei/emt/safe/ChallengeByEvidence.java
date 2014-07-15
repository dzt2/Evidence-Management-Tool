package cn.edu.buaa.sei.emt.safe;

public interface ChallengeByEvidence extends SRelation {
	
	public static final String TYPE_NAME = "safe.ChallengeByEvidence";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public Claim getObjective();
	
	public void setObjective(Claim value);
	
	public EvidenceElement getEvidence();
	
	public void setEvidence(EvidenceElement value);
	
}
