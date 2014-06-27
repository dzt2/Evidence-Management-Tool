package cn.edu.buaa.sei.emt.assurance;
import java.util.List;

public interface EvidenceContainer extends EvidenceElement {
	
	public static final String TYPE_NAME = "evidence.EvidenceContainer";
	public static final String KEY_EVIDENCERELATIONS = "evidenceRelations";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_EVIDENCELIST = "evidenceList";
	public static final String KEY_EVIDENCEEVENTS = "evidenceEvents";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<EvidenceRelation> getEvidenceRelations();
	
	public List<Evidence> getEvidenceList();
	
	public List<EvidenceEvent> getEvidenceEvents();
	
}
