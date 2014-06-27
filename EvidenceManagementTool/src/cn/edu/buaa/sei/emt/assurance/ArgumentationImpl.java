package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ArgumentationImpl extends ManagedObjectImpl implements Argumentation, SafeModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ArgumentationImpl() {
		super(LMFContext.typeForName(Argumentation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Argumentation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Argumentation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Argumentation.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(Argumentation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Argumentation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Argumentation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<ArgumentElement> getElements() {
		return get(Argumentation.KEY_ELEMENTS).listContent().toGenericList(ArgumentElement.class);
	}
	
	@Override
	public Claim getTop_objective() {
		return (Claim) get(Argumentation.KEY_TOP_OBJECTIVE);
	}
	
	@Override
	public void setTop_objective(Claim value) {
		set(Argumentation.KEY_TOP_OBJECTIVE, value);
	}
	
}
