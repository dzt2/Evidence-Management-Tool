package cn.edu.buaa.sei.emt.assurance;

public interface Assurance extends SafeModelElement {
	
	public static final String TYPE_NAME = "argument.Assurance";
	public static final String KEY_EVIDENCE_CONTAINER = "evidence_container";
	public static final String KEY_ARGUMENTATION = "argumentation";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public Argumentation getArgumentation();
	
	public void setArgumentation(Argumentation value);
	
	public Claim getObjective();
	
	public void setObjective(Claim value);
	
	public EvidenceContainer getEvidence_container();
	
	public void setEvidence_container(EvidenceContainer value);
	
}
