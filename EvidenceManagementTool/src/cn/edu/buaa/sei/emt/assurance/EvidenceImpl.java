package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceImpl extends ManagedObjectImpl implements Evidence, EvidenceElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceImpl() {
		super(LMFContext.typeForName(Evidence.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Evidence.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Evidence.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Evidence.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(Evidence.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Evidence.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Evidence.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EvidenceProperty> getProperties() {
		return get(Evidence.KEY_PROPERTIES).listContent().toGenericList(EvidenceProperty.class);
	}
	
}
