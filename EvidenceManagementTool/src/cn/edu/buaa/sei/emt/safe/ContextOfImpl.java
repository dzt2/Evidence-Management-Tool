package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ContextOfImpl extends ManagedObjectImpl implements ContextOf, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ContextOfImpl() {
		super(LMFContext.typeForName(ContextOf.TYPE_NAME));
	}
	
	@Override
	public Assertion getObjective() {
		return (Assertion) get(ContextOf.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Assertion value) {
		set(ContextOf.KEY_OBJECTIVE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(ContextOf.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(ContextOf.KEY_SOURCE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(ContextOf.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(ContextOf.KEY_TARGET, value);
	}
	
	@Override
	public Context getContext() {
		return (Context) get(ContextOf.KEY_CONTEXT);
	}
	
	@Override
	public void setContext(Context value) {
		set(ContextOf.KEY_CONTEXT, value);
	}
	
}
