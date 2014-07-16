package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ContextOfImpl extends ManagedObjectImpl implements ContextOf, SUtilityRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ContextOfImpl() {
		super(LMFContext.typeForName(ContextOf.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ContextOf.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ContextOf.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ContextOf.KEY_ID, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(ContextOf.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(ContextOf.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(ContextOf.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ContextOf.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(ContextOf.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(ContextOf.KEY_TARGET, value);
	}
	
	@Override
	public Context getContext() {
		return (Context) get(ContextOf.KEY_CONTEXT);
	}
	
	@Override
	public void setContext(Context value) {
		set(ContextOf.KEY_CONTEXT, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ContextOf.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Assertion getAssertion() {
		return (Assertion) get(ContextOf.KEY_ASSERTION);
	}
	
	@Override
	public void setAssertion(Assertion value) {
		set(ContextOf.KEY_ASSERTION, value);
	}
	
}
