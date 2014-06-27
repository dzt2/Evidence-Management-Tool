package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ArgumentReasonImpl extends ManagedObjectImpl implements ArgumentReason, ArgumentElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ArgumentReasonImpl() {
		super(LMFContext.typeForName(ArgumentReason.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ArgumentReason.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ArgumentReason.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ArgumentReason.KEY_ID, value);
	}
	
	@Override
	public String getReason() {
		return get(ArgumentReason.KEY_REASON).stringValue();
	}
	
	@Override
	public void setReason(String value) {
		set(ArgumentReason.KEY_REASON, value);
	}
	
	@Override
	public String getName() {
		return get(ArgumentReason.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ArgumentReason.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ArgumentReason.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ArgumentReason.KEY_GID, value);
	}
	
	@Override
	public AssertionRelation getRelation() {
		return (AssertionRelation) get(ArgumentReason.KEY_RELATION);
	}
	
	@Override
	public void setRelation(AssertionRelation value) {
		set(ArgumentReason.KEY_RELATION, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ArgumentReason.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
