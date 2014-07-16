package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class InferenceImpl extends ManagedObjectImpl implements Inference, Assertion, SMainNode {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public InferenceImpl() {
		super(LMFContext.typeForName(Inference.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Inference.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Inference.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Inference.KEY_ID, value);
	}
	
	@Override
	public String getStatement() {
		return get(Inference.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(Inference.KEY_STATEMENT, value);
	}
	
	@Override
	public boolean getValid() {
		return get(Inference.KEY_VALID).boolValue();
	}
	
	@Override
	public void setValid(boolean value) {
		set(Inference.KEY_VALID, value);
	}
	
	@Override
	public List<Claim> getPremises() {
		return get(Inference.KEY_PREMISES).listContent().toGenericList(Claim.class);
	}
	
	@Override
	public String getName() {
		return get(Inference.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Inference.KEY_NAME, value);
	}
	
	@Override
	public List<Assumption> getAssumptions() {
		return get(Inference.KEY_ASSUMPTIONS).listContent().toGenericList(Assumption.class);
	}
	
	@Override
	public String getGid() {
		return get(Inference.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Inference.KEY_GID, value);
	}
	
	@Override
	public List<Justification> getJustifications() {
		return get(Inference.KEY_JUSTIFICATIONS).listContent().toGenericList(Justification.class);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(Inference.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public ImplClaim getConclusion() {
		return (ImplClaim) get(Inference.KEY_CONCLUSION);
	}
	
	@Override
	public void setConclusion(ImplClaim value) {
		set(Inference.KEY_CONCLUSION, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Inference.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
