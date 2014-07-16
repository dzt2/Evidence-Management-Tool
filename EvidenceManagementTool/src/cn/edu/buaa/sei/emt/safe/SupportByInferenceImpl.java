package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SupportByInferenceImpl extends ManagedObjectImpl implements SupportByInference, SMainRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SupportByInferenceImpl() {
		super(LMFContext.typeForName(SupportByInference.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SupportByInference.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(SupportByInference.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SupportByInference.KEY_ID, value);
	}
	
	@Override
	public Inference getInference() {
		return (Inference) get(SupportByInference.KEY_INFERENCE);
	}
	
	@Override
	public void setInference(Inference value) {
		set(SupportByInference.KEY_INFERENCE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(SupportByInference.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(SupportByInference.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(SupportByInference.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SupportByInference.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(SupportByInference.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(SupportByInference.KEY_TARGET, value);
	}
	
	@Override
	public ImplClaim getConclusion() {
		return (ImplClaim) get(SupportByInference.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(ImplClaim value) {
		set(SupportByInference.KEY_CONCLUSION, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(SupportByInference.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
