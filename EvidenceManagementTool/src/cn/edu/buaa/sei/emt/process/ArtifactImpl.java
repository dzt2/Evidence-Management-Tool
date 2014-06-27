package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ArtifactImpl extends ManagedObjectImpl implements Artifact, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ArtifactImpl() {
		super(LMFContext.typeForName(Artifact.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Artifact.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Artifact.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Artifact.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(Artifact.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Artifact.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Artifact.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
