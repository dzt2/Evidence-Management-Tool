package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceStatusImpl extends ManagedObjectImpl implements EvidenceStatus, EvidenceProperty {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceStatusImpl() {
		super(LMFContext.typeForName(EvidenceStatus.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceStatus.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceStatus.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceStatus.KEY_ID, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(EvidenceStatus.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(EvidenceStatus.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceStatus.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceStatus.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceStatus.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(EvidenceStatus.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(EvidenceStatus.KEY_TYPE, value);
	}
	
}
