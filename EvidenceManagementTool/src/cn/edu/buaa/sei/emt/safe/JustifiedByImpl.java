package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class JustifiedByImpl extends ManagedObjectImpl implements JustifiedBy, SUtilityRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public JustifiedByImpl() {
		super(LMFContext.typeForName(JustifiedBy.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(JustifiedBy.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(JustifiedBy.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(JustifiedBy.KEY_ID, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(JustifiedBy.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(JustifiedBy.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(JustifiedBy.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(JustifiedBy.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(JustifiedBy.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(JustifiedBy.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(JustifiedBy.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Assertion getAssertion() {
		return (Assertion) get(JustifiedBy.KEY_ASSERTION);
	}
	
	@Override
	public void setAssertion(Assertion value) {
		set(JustifiedBy.KEY_ASSERTION, value);
	}
	
	@Override
	public Justification getJustification() {
		return (Justification) get(JustifiedBy.KEY_JUSTIFICATION);
	}
	
	@Override
	public void setJustification(Justification value) {
		set(JustifiedBy.KEY_JUSTIFICATION, value);
	}
	
}
