package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class SafeModelElementImpl extends ManagedObjectImpl implements SafeModelElement, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SafeModelElementImpl() {
		super(LMFContext.typeForName(SafeModelElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SafeModelElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(SafeModelElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SafeModelElement.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(SafeModelElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SafeModelElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(SafeModelElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
