package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ArgumentCitationImpl extends ManagedObjectImpl implements ArgumentCitation, ArgumentElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ArgumentCitationImpl() {
		super(LMFContext.typeForName(ArgumentCitation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ArgumentCitation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ArgumentCitation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ArgumentCitation.KEY_ID, value);
	}
	
	@Override
	public Argumentation getArgumentation() {
		return (Argumentation) get(ArgumentCitation.KEY_ARGUMENTATION);
	}
	
	@Override
	public void setArgumentation(Argumentation value) {
		set(ArgumentCitation.KEY_ARGUMENTATION, value);
	}
	
	@Override
	public String getName() {
		return get(ArgumentCitation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ArgumentCitation.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ArgumentCitation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ArgumentCitation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ArgumentCitation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
