package cn.edu.buaa.sei.emt.safe;

public interface EvidenceReference extends SNode {
	
	public static final String TYPE_NAME = "safe.EvidenceReference";
	public static final String KEY_NAME = "name";
	public static final String KEY_EVIDENCE = "evidence";
	
	
	public EvidenceElement getEvidence();
	
	public void setEvidence(EvidenceElement value);
	
}
