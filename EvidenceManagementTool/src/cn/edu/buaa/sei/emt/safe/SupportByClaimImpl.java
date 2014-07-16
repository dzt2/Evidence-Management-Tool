package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SupportByClaimImpl extends ManagedObjectImpl implements SupportByClaim, SMainRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SupportByClaimImpl() {
		super(LMFContext.typeForName(SupportByClaim.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SupportByClaim.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(SupportByClaim.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SupportByClaim.KEY_ID, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(SupportByClaim.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(SupportByClaim.KEY_SOURCE, value);
	}
	
	@Override
	public Claim getPremise() {
		return (Claim) get(SupportByClaim.KEY_PREMISE);
	}
	
	@Override
	public void setPremise(Claim value) {
		set(SupportByClaim.KEY_PREMISE, value);
	}
	
	@Override
	public String getGid() {
		return get(SupportByClaim.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SupportByClaim.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(SupportByClaim.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(SupportByClaim.KEY_TARGET, value);
	}
	
	@Override
	public ImplClaim getConclusion() {
		return (ImplClaim) get(SupportByClaim.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(ImplClaim value) {
		set(SupportByClaim.KEY_CONCLUSION, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(SupportByClaim.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
