package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ArgumentElementImpl extends ManagedObjectImpl implements ArgumentElement, SafeModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ArgumentElementImpl() {
		super(LMFContext.typeForName(ArgumentElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ArgumentElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ArgumentElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ArgumentElement.KEY_ID, value);
	}
	
	@Override
	public String getName() {
		return get(ArgumentElement.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ArgumentElement.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ArgumentElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ArgumentElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ArgumentElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
