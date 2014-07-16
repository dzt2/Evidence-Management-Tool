package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssumptionImpl extends ManagedObjectImpl implements Assumption, SUtilityNode, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssumptionImpl() {
		super(LMFContext.typeForName(Assumption.TYPE_NAME));
	}
	
	@Override
	public String getStatement() {
		return get(Assumption.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(Assumption.KEY_STATEMENT, value);
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Assumption.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Assumption.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Assumption.KEY_ID, value);
	}
	
	@Override
	public boolean getValid() {
		return get(Assumption.KEY_VALID).boolValue();
	}
	
	@Override
	public void setValid(boolean value) {
		set(Assumption.KEY_VALID, value);
	}
	
	@Override
	public List<Assertion> getAssertions() {
		return get(Assumption.KEY_ASSERTIONS).listContent().toGenericList(Assertion.class);
	}
	
	@Override
	public List<Assumption> getAssumptions() {
		return get(Assumption.KEY_ASSUMPTIONS).listContent().toGenericList(Assumption.class);
	}
	
	@Override
	public String getName() {
		return get(Assumption.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Assumption.KEY_NAME, value);
	}
	
	@Override
	public List<Justification> getJustifications() {
		return get(Assumption.KEY_JUSTIFICATIONS).listContent().toGenericList(Justification.class);
	}
	
	@Override
	public String getGid() {
		return get(Assumption.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Assumption.KEY_GID, value);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(Assumption.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Assumption.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
