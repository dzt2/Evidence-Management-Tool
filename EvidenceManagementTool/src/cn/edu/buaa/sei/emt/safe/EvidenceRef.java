package cn.edu.buaa.sei.emt.safe;

public interface EvidenceRef extends SMainNode, SInformationElement {
	
	public static final String TYPE_NAME = "safe.EvidenceRef";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public SEvidenceElement getEvidence();
	
	public void setEvidence(SEvidenceElement value);
	
}
