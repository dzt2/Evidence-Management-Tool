package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidencePropertyImpl extends ManagedObjectImpl implements EvidenceProperty, EvidenceElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidencePropertyImpl() {
		super(LMFContext.typeForName(EvidenceProperty.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceProperty.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceProperty.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceProperty.KEY_ID, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(EvidenceProperty.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(EvidenceProperty.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceProperty.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceProperty.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceProperty.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
