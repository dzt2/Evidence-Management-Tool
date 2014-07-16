package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class JustificationImpl extends ManagedObjectImpl implements Justification, SUtilityNode {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public JustificationImpl() {
		super(LMFContext.typeForName(Justification.TYPE_NAME));
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
	public List<Assertion> getAssertions() {
		return get(Justification.KEY_ASSERTIONS).listContent().toGenericList(Assertion.class);
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
	public String getGid() {
		return get(Justification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Justification.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Justification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
