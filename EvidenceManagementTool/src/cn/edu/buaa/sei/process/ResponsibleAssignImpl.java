package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ResponsibleAssignImpl extends ManagedObjectImpl implements ResponsibleAssign, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ResponsibleAssignImpl() {
		super(LMFContext.typeForName(ResponsibleAssign.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ResponsibleAssign.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ResponsibleAssign.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ResponsibleAssign.KEY_ID, value);
	}
	
	@Override
	public Artifact getArtifact() {
		return (Artifact) get(ResponsibleAssign.KEY_ARTIFACT);
	}
	
	@Override
	public void setArtifact(Artifact value) {
		set(ResponsibleAssign.KEY_ARTIFACT, value);
	}
	
	@Override
	public String getGid() {
		return get(ResponsibleAssign.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ResponsibleAssign.KEY_GID, value);
	}
	
	@Override
	public Role getRole() {
		return (Role) get(ResponsibleAssign.KEY_ROLE);
	}
	
	@Override
	public void setRole(Role value) {
		set(ResponsibleAssign.KEY_ROLE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ResponsibleAssign.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(ResponsibleAssign.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(ResponsibleAssign.KEY_TYPE, value);
	}
	
}
