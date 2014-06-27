package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssertionImpl extends ManagedObjectImpl implements Assertion, ArgumentElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssertionImpl() {
		super(LMFContext.typeForName(Assertion.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Assertion.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Assertion.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Assertion.KEY_ID, value);
	}
	
	@Override
	public String getDescription() {
		return get(Assertion.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(Assertion.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(Assertion.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Assertion.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Assertion.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Assertion.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Assertion.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
