package cn.edu.buaa.sei.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PMProjectImpl extends ManagedObjectImpl implements PMProject, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PMProjectImpl() {
		super(LMFContext.typeForName(PMProject.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(PMProject.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(PMProject.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(PMProject.KEY_ID, value);
	}
	
	@Override
	public List<Role> getRoleList() {
		return get(PMProject.KEY_ROLELIST).listContent().toGenericList(Role.class);
	}
	
	@Override
	public List<Artifact> getArtifactList() {
		return get(PMProject.KEY_ARTIFACTLIST).listContent().toGenericList(Artifact.class);
	}
	
	@Override
	public List<ProcessGroup> getProcessGroupList() {
		return get(PMProject.KEY_PROCESSGROUPLIST).listContent().toGenericList(ProcessGroup.class);
	}
	
	@Override
	public List<Process> getProcessList() {
		return get(PMProject.KEY_PROCESSLIST).listContent().toGenericList(Process.class);
	}
	
	@Override
	public String getGid() {
		return get(PMProject.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(PMProject.KEY_GID, value);
	}
	
	@Override
	public List<ArtifactRelation> getArtifactRelationList() {
		return get(PMProject.KEY_ARTIFACTRELATIONLIST).listContent().toGenericList(ArtifactRelation.class);
	}
	
	@Override
	public List<RoleRelation> getRoleRelationList() {
		return get(PMProject.KEY_ROLERELATIONLIST).listContent().toGenericList(RoleRelation.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(PMProject.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<Organization> getOrganizationList() {
		return get(PMProject.KEY_ORGANIZATIONLIST).listContent().toGenericList(Organization.class);
	}
	
	@Override
	public List<ProcessSequence> getProcessSequenceList() {
		return get(PMProject.KEY_PROCESSSEQUENCELIST).listContent().toGenericList(ProcessSequence.class);
	}
	
}
