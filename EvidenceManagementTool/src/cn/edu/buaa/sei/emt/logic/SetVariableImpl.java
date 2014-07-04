package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SetVariableImpl extends ManagedObjectImpl implements SetVariable, Variable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SetVariableImpl() {
		super(LMFContext.typeForName(SetVariable.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SetVariable.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(SetVariable.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SetVariable.KEY_ID, value);
	}
	
	@Override
	public EntitySet getSet() {
		return (EntitySet) get(SetVariable.KEY_SET);
	}
	
	@Override
	public void setSet(EntitySet value) {
		set(SetVariable.KEY_SET, value);
	}
	
	@Override
	public String getName() {
		return get(SetVariable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(SetVariable.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(SetVariable.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SetVariable.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(SetVariable.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public EntityElement getBindTo() {
		return (EntityElement) get(SetVariable.KEY_BINDTO);
	}
	
	@Override
	public void setBindTo(EntityElement value) {
		set(SetVariable.KEY_BINDTO, value);
	}
	
}
