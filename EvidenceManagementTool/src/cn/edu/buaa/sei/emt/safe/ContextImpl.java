package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ContextImpl extends ManagedObjectImpl implements Context, SNode {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ContextImpl() {
		super(LMFContext.typeForName(Context.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(Context.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Context.KEY_NAME, value);
	}
	
	@Override
	public String getContext() {
		return get(Context.KEY_CONTEXT).stringValue();
	}
	
	@Override
	public void setContext(String value) {
		set(Context.KEY_CONTEXT, value);
	}
	
}
