package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class BooleanValueImpl extends ManagedObjectImpl implements BooleanValue, Value {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public BooleanValueImpl() {
		super(LMFContext.typeForName(BooleanValue.TYPE_NAME));
	}
	
	@Override
	public boolean getBool_val() {
		return get(BooleanValue.KEY_BOOL_VAL).boolValue();
	}
	
	@Override
	public void setBool_val(boolean value) {
		set(BooleanValue.KEY_BOOL_VAL, value);
	}
	
}
