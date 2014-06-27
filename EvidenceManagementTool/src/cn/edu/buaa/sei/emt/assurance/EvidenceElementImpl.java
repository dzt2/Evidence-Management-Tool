package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceElementImpl extends ManagedObjectImpl implements EvidenceElement, SafeModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceElementImpl() {
		super(LMFContext.typeForName(EvidenceElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceElement.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
