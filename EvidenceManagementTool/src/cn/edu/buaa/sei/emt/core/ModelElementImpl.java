package cn.edu.buaa.sei.emt.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ModelElementImpl extends ManagedObjectImpl implements ModelElement, Element {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ModelElementImpl() {
		super(LMFContext.typeForName(ModelElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ModelElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ModelElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ModelElement.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(ModelElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ModelElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ModelElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
