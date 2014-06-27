package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ContextRelationImpl extends ManagedObjectImpl implements ContextRelation, AssertionRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ContextRelationImpl() {
		super(LMFContext.typeForName(ContextRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ContextRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ContextRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ContextRelation.KEY_ID, value);
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(ContextRelation.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(ContextRelation.KEY_OBJECTIVE, value);
	}
	
	@Override
	public String getDescription() {
		return get(ContextRelation.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(ContextRelation.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(ContextRelation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ContextRelation.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ContextRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ContextRelation.KEY_GID, value);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(ContextRelation.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ContextRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
