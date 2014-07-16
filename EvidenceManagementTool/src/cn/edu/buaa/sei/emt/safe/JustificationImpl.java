package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class JustificationImpl extends ManagedObjectImpl implements Justification, SUtilityNode, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public JustificationImpl() {
		super(LMFContext.typeForName(Justification.TYPE_NAME));
	}
	
	@Override
	public String getStatement() {
		return get(Justification.KEY_STATEMENT).stringValue();
	}
	
	@Override
	public void setStatement(String value) {
		set(Justification.KEY_STATEMENT, value);
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Justification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Justification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Justification.KEY_ID, value);
	}
	
	@Override
	public boolean getValid() {
		return get(Justification.KEY_VALID).boolValue();
	}
	
	@Override
	public void setValid(boolean value) {
		set(Justification.KEY_VALID, value);
	}
	
	@Override
	public List<Assertion> getAssertions() {
		return get(Justification.KEY_ASSERTIONS).listContent().toGenericList(Assertion.class);
	}
	
	@Override
	public List<Assumption> getAssumptions() {
		return get(Justification.KEY_ASSUMPTIONS).listContent().toGenericList(Assumption.class);
	}
	
	@Override
	public String getName() {
		return get(Justification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Justification.KEY_NAME, value);
	}
	
	@Override
	public List<Justification> getJustifications() {
		return get(Justification.KEY_JUSTIFICATIONS).listContent().toGenericList(Justification.class);
	}
	
	@Override
	public String getGid() {
		return get(Justification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Justification.KEY_GID, value);
	}
	
	@Override
	public List<Context> getContexts() {
		return get(Justification.KEY_CONTEXTS).listContent().toGenericList(Context.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Justification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
