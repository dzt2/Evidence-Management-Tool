package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.ModelElement;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EntityIndividualImpl extends ManagedObjectImpl implements EntityIndividual, EntityElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EntityIndividualImpl() {
		super(LMFContext.typeForName(EntityIndividual.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EntityIndividual.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EntityIndividual.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EntityIndividual.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EntityIndividual.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EntityIndividual.KEY_GID, value);
	}
	
	@Override
	public ModelElement getValue() {
		return (ModelElement) get(EntityIndividual.KEY_VALUE);
	}
	
	@Override
	public void setValue(ModelElement value) {
		set(EntityIndividual.KEY_VALUE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EntityIndividual.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
