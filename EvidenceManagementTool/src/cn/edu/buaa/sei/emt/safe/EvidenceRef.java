package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface EvidenceRef extends SMainNode, SInformationElement {
	
	public static final String KEY_SUPPORT_CLAIMS = "support_claims";
	public static final String TYPE_NAME = "safe.EvidenceRef";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_STATE = "state";
	
	
	public Evidence getEvidence();
	
	public void setEvidence(Evidence value);
	
	public int getState();
	
	public void setState(int value);
	
	public List<ImplClaim> getSupport_claims();
	
}
