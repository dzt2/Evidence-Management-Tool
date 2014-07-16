package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class UndevClaimImpl extends ManagedObjectImpl implements UndevClaim, Claim {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public UndevClaimImpl() {
		super(LMFContext.typeForName(UndevClaim.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(UndevClaim.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public boolean getResult() {
		return get(UndevClaim.KEY_RESULT).boolValue();
	}
	
	@Override
	public void setResult(boolean value) {
		set(UndevClaim.KEY_RESULT, value);
	}
	
	@Override
	public boolean getValid() {
		return get(UndevClaim.KEY_VALID).boolValue();
	}
	
	@Override
	public void setValid(boolean value) {
		set(UndevClaim.KEY_VALID, value);
	}
	
	@Override
	public SafetyCase getRefcase() {
		return (SafetyCase) get(UndevClaim.KEY_REFCASE);
	}
	
	@Override
	public void setRefcase(SafetyCase value) {
		set(UndevClaim.KEY_REFCASE, value);
	}
	
	@Override
	public int getState() {
		return get(UndevClaim.KEY_STATE).intValue();
	}
	
	@Override
	public void setState(int value) {
		set(UndevClaim.KEY_STATE, value);
	}
	
	@Override
	public boolean getAssumed_result() {
		return get(UndevClaim.KEY_ASSUMED_RESULT).boolValue();
	}
	
	@Override
	public void setAssumed_result(boolean value) {
		set(UndevClaim.KEY_ASSUMED_RESULT, value);
	}
	
	@Override
	public String getId() {
		return get(UndevClaim.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(UndevClaim.KEY_ID, value);
	}
	
	@Override
	public String getStatement() {
		return get(UndevClaim.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(UndevClaim.KEY_STATEMENT, value);
	}
	
	@Override
	public List<Assumption> getAssumptions() {
		return get(UndevClaim.KEY_ASSUMPTIONS).listContent().toGenericList(Assumption.class);
	}
	
	@Override
	public String getName() {
		return get(UndevClaim.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(UndevClaim.KEY_NAME, value);
	}
	
	@Override
	public List<Justification> getJustifications() {
		return get(UndevClaim.KEY_JUSTIFICATIONS).listContent().toGenericList(Justification.class);
	}
	
	@Override
	public String getGid() {
		return get(UndevClaim.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(UndevClaim.KEY_GID, value);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(UndevClaim.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(UndevClaim.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
