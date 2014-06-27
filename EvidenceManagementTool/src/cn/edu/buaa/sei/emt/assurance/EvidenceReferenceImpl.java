package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceReferenceImpl extends ManagedObjectImpl implements EvidenceReference, BasicEvidence {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceReferenceImpl() {
		super(LMFContext.typeForName(EvidenceReference.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceReference.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceReference.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceReference.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceReference.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceReference.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceReference.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EvidenceProperty> getProperties() {
		return get(EvidenceReference.KEY_PROPERTIES).listContent().toGenericList(EvidenceProperty.class);
	}
	
}
