package cn.edu.buaa.sei.emt.logic;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EntityRelationImpl extends ManagedObjectImpl implements EntityRelation, EntityElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EntityRelationImpl() {
		super(LMFContext.typeForName(EntityRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EntityRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EntityRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EntityRelation.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EntityRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EntityRelation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EntityRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EntityElement> getElements() {
		return get(EntityRelation.KEY_ELEMENTS).listContent().toGenericList(EntityElement.class);
	}
	
}
