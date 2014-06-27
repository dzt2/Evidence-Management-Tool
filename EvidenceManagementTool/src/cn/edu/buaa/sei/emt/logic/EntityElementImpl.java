package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class EntityElementImpl extends ManagedObjectImpl implements EntityElement, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EntityElementImpl() {
		super(LMFContext.typeForName(EntityElement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EntityElement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EntityElement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EntityElement.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EntityElement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EntityElement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EntityElement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
