package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssumedByImpl extends ManagedObjectImpl implements AssumedBy, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssumedByImpl() {
		super(LMFContext.typeForName(AssumedBy.TYPE_NAME));
	}
	
	@Override
	public Assertion getObjective() {
		return (Assertion) get(AssumedBy.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Assertion value) {
		set(AssumedBy.KEY_OBJECTIVE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(AssumedBy.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(AssumedBy.KEY_SOURCE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(AssumedBy.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(AssumedBy.KEY_TARGET, value);
	}
	
	@Override
	public Assumption getAssumption() {
		return (Assumption) get(AssumedBy.KEY_ASSUMPTION);
	}
	
	@Override
	public void setAssumption(Assumption value) {
		set(AssumedBy.KEY_ASSUMPTION, value);
	}
	
}
