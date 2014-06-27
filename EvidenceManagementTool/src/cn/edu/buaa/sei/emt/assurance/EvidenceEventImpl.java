package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceEventImpl extends ManagedObjectImpl implements EvidenceEvent, EvidenceElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceEventImpl() {
		super(LMFContext.typeForName(EvidenceEvent.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceEvent.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceEvent.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceEvent.KEY_ID, value);
	}
	
	@Override
	public SafeRole getExecutor() {
		return (SafeRole) get(EvidenceEvent.KEY_EXECUTOR);
	}
	
	@Override
	public void setExecutor(SafeRole value) {
		set(EvidenceEvent.KEY_EXECUTOR, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(EvidenceEvent.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(EvidenceEvent.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceEvent.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceEvent.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceEvent.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(EvidenceEvent.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(EvidenceEvent.KEY_TYPE, value);
	}
	
}
