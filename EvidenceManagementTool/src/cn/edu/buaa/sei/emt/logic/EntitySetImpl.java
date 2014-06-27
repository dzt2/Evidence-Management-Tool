package cn.edu.buaa.sei.emt.logic;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EntitySetImpl extends ManagedObjectImpl implements EntitySet, EntityElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EntitySetImpl() {
		super(LMFContext.typeForName(EntitySet.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EntitySet.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EntitySet.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EntitySet.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EntitySet.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EntitySet.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EntitySet.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EntityElement> getElements() {
		return get(EntitySet.KEY_ELEMENTS).listContent().toGenericList(EntityElement.class);
	}
	
}
