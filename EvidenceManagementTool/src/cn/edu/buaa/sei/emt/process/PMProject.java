package cn.edu.buaa.sei.emt.process;
import java.util.List;

public interface PMProject extends PMElement {
	
	public static final String KEY_ARTIFACTRELATIONLIST = "artifactRelationList";
	public static final String KEY_PROCESSLIST = "processList";
	public static final String KEY_ROLERELATIONLIST = "roleRelationList";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String TYPE_NAME = "process.PMProject";
	public static final String KEY_ROLELIST = "roleList";
	public static final String KEY_PROCESSGROUPLIST = "processGroupList";
	public static final String KEY_ARTIFACTLIST = "artifactList";
	public static final String KEY_PROCESSSEQUENCELIST = "processSequenceList";
	public static final String KEY_ORGANIZATIONLIST = "organizationList";
	
	
	public List<Role> getRoleList();
	
	public List<Artifact> getArtifactList();
	
	public List<ProcessGroup> getProcessGroupList();
	
	public List<Process> getProcessList();
	
	public List<ArtifactRelation> getArtifactRelationList();
	
	public List<RoleRelation> getRoleRelationList();
	
	public List<Organization> getOrganizationList();
	
	public List<ProcessSequence> getProcessSequenceList();
	
}
