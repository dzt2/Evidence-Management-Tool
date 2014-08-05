package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class LObjectImpl extends ManagedObjectImpl implements LObject, Value {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public LObjectImpl() {
		super(LMFContext.typeForName(LObject.TYPE_NAME));
	}
	
	@Override
	public String getId() {
		return get(LObject.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(LObject.KEY_ID, value);
	}
	
}
