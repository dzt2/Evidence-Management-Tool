package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
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
	public Evidence getEvidence() {
		return (Evidence) get(EvidenceRef.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
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
	public int getState() {
		return get(EvidenceRef.KEY_STATE).intValue();
	}
	
	@Override
	public void setState(int value) {
		set(EvidenceRef.KEY_STATE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceRef.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<ImplClaim> getSupport_claims() {
		return get(EvidenceRef.KEY_SUPPORT_CLAIMS).listContent().toGenericList(ImplClaim.class);
	}
	
}
