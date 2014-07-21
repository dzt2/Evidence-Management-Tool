package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class InferenceSupportByClaimImpl extends ManagedObjectImpl implements InferenceSupportByClaim, SMainRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public InferenceSupportByClaimImpl() {
		super(LMFContext.typeForName(InferenceSupportByClaim.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(InferenceSupportByClaim.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(InferenceSupportByClaim.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(InferenceSupportByClaim.KEY_ID, value);
	}
	
	@Override
	public Inference getInference() {
		return (Inference) get(InferenceSupportByClaim.KEY_INFERENCE);
	}
	
	@Override
	public void setInference(Inference value) {
		set(InferenceSupportByClaim.KEY_INFERENCE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(InferenceSupportByClaim.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(InferenceSupportByClaim.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(InferenceSupportByClaim.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(InferenceSupportByClaim.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(InferenceSupportByClaim.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(InferenceSupportByClaim.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(InferenceSupportByClaim.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Claim getClaim() {
		return (Claim) get(InferenceSupportByClaim.KEY_CLAIM);
	}
	
	@Override
	public void setClaim(Claim value) {
		set(InferenceSupportByClaim.KEY_CLAIM, value);
	}
	
}
