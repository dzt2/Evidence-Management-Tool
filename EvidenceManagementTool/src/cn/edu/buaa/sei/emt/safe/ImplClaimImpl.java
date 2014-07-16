package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ImplClaimImpl extends ManagedObjectImpl implements ImplClaim, Claim {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ImplClaimImpl() {
		super(LMFContext.typeForName(ImplClaim.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ImplClaim.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public boolean getValid() {
		return get(ImplClaim.KEY_VALID).boolValue();
	}
	
	@Override
	public void setValid(boolean value) {
		set(ImplClaim.KEY_VALID, value);
	}
	
	@Override
	public boolean getResult() {
		return get(ImplClaim.KEY_RESULT).boolValue();
	}
	
	@Override
	public void setResult(boolean value) {
		set(ImplClaim.KEY_RESULT, value);
	}
	
	@Override
	public List<Claim> getSub_claims() {
		return get(ImplClaim.KEY_SUB_CLAIMS).listContent().toGenericList(Claim.class);
	}
	
	@Override
	public List<Inference> getInferences() {
		return get(ImplClaim.KEY_INFERENCES).listContent().toGenericList(Inference.class);
	}
	
	@Override
	public int getState() {
		return get(ImplClaim.KEY_STATE).intValue();
	}
	
	@Override
	public void setState(int value) {
		set(ImplClaim.KEY_STATE, value);
	}
	
	@Override
	public boolean getAssumed_result() {
		return get(ImplClaim.KEY_ASSUMED_RESULT).boolValue();
	}
	
	@Override
	public void setAssumed_result(boolean value) {
		set(ImplClaim.KEY_ASSUMED_RESULT, value);
	}
	
	@Override
	public String getId() {
		return get(ImplClaim.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ImplClaim.KEY_ID, value);
	}
	
	@Override
	public String getStatement() {
		return get(ImplClaim.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(ImplClaim.KEY_STATEMENT, value);
	}
	
	@Override
	public List<Assumption> getAssumptions() {
		return get(ImplClaim.KEY_ASSUMPTIONS).listContent().toGenericList(Assumption.class);
	}
	
	@Override
	public String getName() {
		return get(ImplClaim.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ImplClaim.KEY_NAME, value);
	}
	
	@Override
	public List<Justification> getJustifications() {
		return get(ImplClaim.KEY_JUSTIFICATIONS).listContent().toGenericList(Justification.class);
	}
	
	@Override
	public String getGid() {
		return get(ImplClaim.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ImplClaim.KEY_GID, value);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(ImplClaim.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ImplClaim.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EvidenceRef> getEvidences() {
		return get(ImplClaim.KEY_EVIDENCES).listContent().toGenericList(EvidenceRef.class);
	}
	
}
