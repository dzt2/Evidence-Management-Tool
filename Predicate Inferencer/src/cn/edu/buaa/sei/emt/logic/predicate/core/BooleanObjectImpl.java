package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class BooleanObjectImpl extends ManagedObjectImpl implements BooleanObject, LObject {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public BooleanObjectImpl() {
		super(LMFContext.typeForName(BooleanObject.TYPE_NAME));
	}
	
	@Override
	public String getId() {
		return get(BooleanObject.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(BooleanObject.KEY_ID, value);
	}
	
	@Override
	public boolean getBool_val() {
		return get(BooleanObject.KEY_BOOL_VAL).boolValue();
	}
	
	@Override
	public void setBool_val(boolean value) {
		set(BooleanObject.KEY_BOOL_VAL, value);
	}
	
}
