package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class InformationElementImpl extends ManagedObjectImpl implements InformationElement, ArgumentElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public InformationElementImpl() {
		super(LMFContext.typeForName(InformationElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(InformationElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(InformationElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(InformationElement.KEY_ID, value);
	}
	
	@Override
	public String getName() {
		return get(InformationElement.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(InformationElement.KEY_NAME, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(InformationElement.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(InformationElement.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(InformationElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(InformationElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(InformationElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
