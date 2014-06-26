package cn.edu.buaa.sei.emt.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class TaggedValueImpl extends ManagedObjectImpl implements TaggedValue, UtilityElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public TaggedValueImpl() {
		super(LMFContext.typeForName(TaggedValue.TYPE_NAME));
	}
	
	@Override
	public String getValue() {
		return get(TaggedValue.KEY_VALUE).stringValue();
	}
	
	@Override
	public void setValue(String value) {
		set(TaggedValue.KEY_VALUE, value);
	}
	
	@Override
	public String getKey() {
		return get(TaggedValue.KEY_KEY).stringValue();
	}
	
	@Override
	public void setKey(String value) {
		set(TaggedValue.KEY_KEY, value);
	}
	
}
