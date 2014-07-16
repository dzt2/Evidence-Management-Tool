package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceRefImpl extends ManagedObjectImpl implements EvidenceRef, SMainNode, SInformationElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceRefImpl() {
		super(LMFContext.typeForName(EvidenceRef.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceRef.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceRef.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceRef.KEY_ID, value);
	}
	
	@Override
	public String getDescription() {
		return get(EvidenceRef.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(EvidenceRef.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(EvidenceRef.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(EvidenceRef.KEY_NAME, value);
	}
	
	@Override
	public SEvidenceElement getEvidence() {
		return (SEvidenceElement) get(EvidenceRef.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(SEvidenceElement value) {
		set(EvidenceRef.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceRef.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceRef.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceRef.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
