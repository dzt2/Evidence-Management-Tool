package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ArtifactRelationImpl extends ManagedObjectImpl implements ArtifactRelation, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ArtifactRelationImpl() {
		super(LMFContext.typeForName(ArtifactRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ArtifactRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ArtifactRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ArtifactRelation.KEY_ID, value);
	}
	
	@Override
	public Artifact getSource() {
		return (Artifact) get(ArtifactRelation.KEY_SOURCE);
	}
	
	@Override
	public void setSource(Artifact value) {
		set(ArtifactRelation.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(ArtifactRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ArtifactRelation.KEY_GID, value);
	}
	
	@Override
	public Artifact getTarget() {
		return (Artifact) get(ArtifactRelation.KEY_TARGET);
	}
	
	@Override
	public void setTarget(Artifact value) {
		set(ArtifactRelation.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ArtifactRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(ArtifactRelation.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(ArtifactRelation.KEY_TYPE, value);
	}
	
}
