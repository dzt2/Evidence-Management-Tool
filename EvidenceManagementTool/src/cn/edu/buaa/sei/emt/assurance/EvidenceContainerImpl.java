package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceContainerImpl extends ManagedObjectImpl implements EvidenceContainer, EvidenceElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceContainerImpl() {
		super(LMFContext.typeForName(EvidenceContainer.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceContainer.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceContainer.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceContainer.KEY_ID, value);
	}
	
	@Override
	public List<EvidenceRelation> getEvidenceRelations() {
		return get(EvidenceContainer.KEY_EVIDENCERELATIONS).listContent().toGenericList(EvidenceRelation.class);
	}
	
	@Override
	public List<Evidence> getEvidenceList() {
		return get(EvidenceContainer.KEY_EVIDENCELIST).listContent().toGenericList(Evidence.class);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceContainer.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceContainer.KEY_GID, value);
	}
	
	@Override
	public List<EvidenceEvent> getEvidenceEvents() {
		return get(EvidenceContainer.KEY_EVIDENCEEVENTS).listContent().toGenericList(EvidenceEvent.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceContainer.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
