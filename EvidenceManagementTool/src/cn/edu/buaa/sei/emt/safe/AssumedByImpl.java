package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssumedByImpl extends ManagedObjectImpl implements AssumedBy, SUtilityRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssumedByImpl() {
		super(LMFContext.typeForName(AssumedBy.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(AssumedBy.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(AssumedBy.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(AssumedBy.KEY_ID, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(AssumedBy.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(AssumedBy.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(AssumedBy.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(AssumedBy.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(AssumedBy.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(AssumedBy.KEY_TARGET, value);
	}
	
	@Override
	public Assumption getAssumption() {
		return (Assumption) get(AssumedBy.KEY_ASSUMPTION);
	}
	
	@Override
	public void setAssumption(Assumption value) {
		set(AssumedBy.KEY_ASSUMPTION, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(AssumedBy.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Assertion getAssertion() {
		return (Assertion) get(AssumedBy.KEY_ASSERTION);
	}
	
	@Override
	public void setAssertion(Assertion value) {
		set(AssumedBy.KEY_ASSERTION, value);
	}
	
}
