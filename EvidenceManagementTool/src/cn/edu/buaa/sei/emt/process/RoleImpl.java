package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class RoleImpl extends ManagedObjectImpl implements Role, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public RoleImpl() {
		super(LMFContext.typeForName(Role.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Role.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Role.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Role.KEY_ID, value);
	}
	
	@Override
	public Person getPerson() {
		return (Person) get(Role.KEY_PERSON);
	}
	
	@Override
	public void setPerson(Person value) {
		set(Role.KEY_PERSON, value);
	}
	
	@Override
	public String getName() {
		return get(Role.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Role.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Role.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Role.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Role.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
