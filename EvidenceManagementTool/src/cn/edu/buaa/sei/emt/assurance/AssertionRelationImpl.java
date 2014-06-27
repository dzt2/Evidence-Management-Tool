package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssertionRelationImpl extends ManagedObjectImpl implements AssertionRelation, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssertionRelationImpl() {
		super(LMFContext.typeForName(AssertionRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(AssertionRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(AssertionRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(AssertionRelation.KEY_ID, value);
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(AssertionRelation.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(AssertionRelation.KEY_OBJECTIVE, value);
	}
	
	@Override
	public String getDescription() {
		return get(AssertionRelation.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(AssertionRelation.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(AssertionRelation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(AssertionRelation.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(AssertionRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(AssertionRelation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(AssertionRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
