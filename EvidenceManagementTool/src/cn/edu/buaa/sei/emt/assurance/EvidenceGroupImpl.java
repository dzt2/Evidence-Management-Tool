package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceGroupImpl extends ManagedObjectImpl implements EvidenceGroup, Evidence {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceGroupImpl() {
		super(LMFContext.typeForName(EvidenceGroup.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceGroup.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceGroup.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceGroup.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceGroup.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceGroup.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceGroup.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EvidenceProperty> getProperties() {
		return get(EvidenceGroup.KEY_PROPERTIES).listContent().toGenericList(EvidenceProperty.class);
	}
	
	@Override
	public List<Evidence> getSub_evidences() {
		return get(EvidenceGroup.KEY_SUB_EVIDENCES).listContent().toGenericList(Evidence.class);
	}
	
}
