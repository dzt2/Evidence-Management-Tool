package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class RelationVariableImpl extends ManagedObjectImpl implements RelationVariable, Variable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public RelationVariableImpl() {
		super(LMFContext.typeForName(RelationVariable.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(RelationVariable.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(RelationVariable.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(RelationVariable.KEY_ID, value);
	}
	
	@Override
	public String getName() {
		return get(RelationVariable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(RelationVariable.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(RelationVariable.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(RelationVariable.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(RelationVariable.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public EntityElement getBindTo() {
		return (EntityElement) get(RelationVariable.KEY_BINDTO);
	}
	
	@Override
	public void setBindTo(EntityElement value) {
		set(RelationVariable.KEY_BINDTO, value);
	}
	
}
