package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class JustifiedByImpl extends ManagedObjectImpl implements JustifiedBy, SRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public JustifiedByImpl() {
		super(LMFContext.typeForName(JustifiedBy.TYPE_NAME));
	}
	
	@Override
	public Assertion getObjective() {
		return (Assertion) get(JustifiedBy.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Assertion value) {
		set(JustifiedBy.KEY_OBJECTIVE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(JustifiedBy.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(JustifiedBy.KEY_SOURCE, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(JustifiedBy.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(JustifiedBy.KEY_TARGET, value);
	}
	
	@Override
	public Justification getJustification() {
		return (Justification) get(JustifiedBy.KEY_JUSTIFICATION);
	}
	
	@Override
	public void setJustification(Justification value) {
		set(JustifiedBy.KEY_JUSTIFICATION, value);
	}
	
}
