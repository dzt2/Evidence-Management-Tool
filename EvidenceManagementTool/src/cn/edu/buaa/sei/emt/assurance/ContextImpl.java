package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ContextImpl extends ManagedObjectImpl implements Context, ArgumentElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ContextImpl() {
		super(LMFContext.typeForName(Context.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Context.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Context.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Context.KEY_ID, value);
	}
	
	@Override
	public String getDescription() {
		return get(Context.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(Context.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(Context.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Context.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Context.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Context.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Context.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
