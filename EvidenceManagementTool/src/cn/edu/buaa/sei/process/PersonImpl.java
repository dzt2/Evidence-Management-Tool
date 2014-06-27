package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class PersonImpl extends ManagedObjectImpl implements Person, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PersonImpl() {
		super(LMFContext.typeForName(Person.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Person.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Person.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Person.KEY_ID, value);
	}
	
	@Override
	public String getMail() {
		return get(Person.KEY_MAIL).stringValue();
	}
	
	@Override
	public void setMail(String value) {
		set(Person.KEY_MAIL, value);
	}
	
	@Override
	public String getSex() {
		return get(Person.KEY_SEX).stringValue();
	}
	
	@Override
	public void setSex(String value) {
		set(Person.KEY_SEX, value);
	}
	
	@Override
	public String getName() {
		return get(Person.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Person.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Person.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Person.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Person.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
