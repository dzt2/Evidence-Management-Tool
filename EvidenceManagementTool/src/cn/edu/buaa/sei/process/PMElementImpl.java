package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class PMElementImpl extends ManagedObjectImpl implements PMElement, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PMElementImpl() {
		super(LMFContext.typeForName(PMElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(PMElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(PMElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(PMElement.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(PMElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(PMElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(PMElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
