package cn.edu.buaa.sei.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class OrganizationImpl extends ManagedObjectImpl implements Organization, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public OrganizationImpl() {
		super(LMFContext.typeForName(Organization.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Organization.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Organization.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Organization.KEY_ID, value);
	}
	
	@Override
	public List<Role> getRoles() {
		return get(Organization.KEY_ROLES).listContent().toGenericList(Role.class);
	}
	
	@Override
	public String getName() {
		return get(Organization.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Organization.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Organization.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Organization.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Organization.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
