package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ValueVariableImpl extends ManagedObjectImpl implements ValueVariable, Variable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ValueVariableImpl() {
		super(LMFContext.typeForName(ValueVariable.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ValueVariable.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ValueVariable.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ValueVariable.KEY_ID, value);
	}
	
	@Override
	public String getName() {
		return get(ValueVariable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ValueVariable.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ValueVariable.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ValueVariable.KEY_GID, value);
	}
	
	@Override
	public EntityValue getValue() {
		return (EntityValue) get(ValueVariable.KEY_VALUE);
	}
	
	@Override
	public void setValue(EntityValue value) {
		set(ValueVariable.KEY_VALUE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ValueVariable.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public EntityElement getBindTo() {
		return (EntityElement) get(ValueVariable.KEY_BINDTO);
	}
	
	@Override
	public void setBindTo(EntityElement value) {
		set(ValueVariable.KEY_BINDTO, value);
	}
	
}
