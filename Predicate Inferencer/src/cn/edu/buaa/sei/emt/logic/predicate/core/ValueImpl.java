package cn.edu.buaa.sei.emt.logic.predicate.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ValueImpl extends ManagedObjectImpl implements Value {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ValueImpl() {
		super(LMFContext.typeForName(Value.TYPE_NAME));
	}
	
}
