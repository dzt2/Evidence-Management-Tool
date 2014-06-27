package cn.edu.buaa.sei.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class ProjectImpl extends ManagedObjectImpl implements Project, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProjectImpl() {
		super(LMFContext.typeForName(Project.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Project.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Project.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Project.KEY_ID, value);
	}
	
	@Override
	public List<Role> getRoleList() {
		return get(Project.KEY_ROLELIST).listContent().toGenericList(Role.class);
	}
	
	@Override
	public List<Artifact> getArtifactList() {
		return get(Project.KEY_ARTIFACTLIST).listContent().toGenericList(Artifact.class);
	}
	
	@Override
	public List<ProcessGroup> getProcessGroupList() {
		return get(Project.KEY_PROCESSGROUPLIST).listContent().toGenericList(ProcessGroup.class);
	}
	
	@Override
	public List<Process> getProcessList() {
		return get(Project.KEY_PROCESSLIST).listContent().toGenericList(Process.class);
	}
	
	@Override
	public String getGid() {
		return get(Project.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Project.KEY_GID, value);
	}
	
	@Override
	public List<ArtifactRelation> getArtifactRelationList() {
		return get(Project.KEY_ARTIFACTRELATIONLIST).listContent().toGenericList(ArtifactRelation.class);
	}
	
	@Override
	public List<RoleRelation> getRoleRelationList() {
		return get(Project.KEY_ROLERELATIONLIST).listContent().toGenericList(RoleRelation.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Project.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<Organization> getOrganizationList() {
		return get(Project.KEY_ORGANIZATIONLIST).listContent().toGenericList(Organization.class);
	}
	
	@Override
	public List<ProcessSequence> getProcessSequenceList() {
		return get(Project.KEY_PROCESSSEQUENCELIST).listContent().toGenericList(ProcessSequence.class);
	}
	
}
