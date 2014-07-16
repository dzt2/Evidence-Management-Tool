package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SupportByEvidenceImpl extends ManagedObjectImpl implements SupportByEvidence, SMainRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SupportByEvidenceImpl() {
		super(LMFContext.typeForName(SupportByEvidence.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SupportByEvidence.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(SupportByEvidence.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SupportByEvidence.KEY_ID, value);
	}
	
	@Override
	public ImplClaim getObjective() {
		return (ImplClaim) get(SupportByEvidence.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(ImplClaim value) {
		set(SupportByEvidence.KEY_OBJECTIVE, value);
	}
	
	@Override
	public SNode getSource() {
		return (SNode) get(SupportByEvidence.KEY_SOURCE);
	}
	
	@Override
	public void setSource(SNode value) {
		set(SupportByEvidence.KEY_SOURCE, value);
	}
	
	@Override
	public EvidenceRef getEvidence() {
		return (EvidenceRef) get(SupportByEvidence.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(EvidenceRef value) {
		set(SupportByEvidence.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(SupportByEvidence.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SupportByEvidence.KEY_GID, value);
	}
	
	@Override
	public SNode getTarget() {
		return (SNode) get(SupportByEvidence.KEY_TARGET);
	}
	
	@Override
	public void setTarget(SNode value) {
		set(SupportByEvidence.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(SupportByEvidence.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
