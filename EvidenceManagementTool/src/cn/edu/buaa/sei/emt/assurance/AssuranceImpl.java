package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AssuranceImpl extends ManagedObjectImpl implements Assurance, SafeModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AssuranceImpl() {
		super(LMFContext.typeForName(Assurance.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Assurance.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Assurance.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Assurance.KEY_ID, value);
	}
	
	@Override
	public Argumentation getArgumentation() {
		return (Argumentation) get(Assurance.KEY_ARGUMENTATION);
	}
	
	@Override
	public void setArgumentation(Argumentation value) {
		set(Assurance.KEY_ARGUMENTATION, value);
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(Assurance.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(Assurance.KEY_OBJECTIVE, value);
	}
	
	@Override
	public EvidenceContainer getEvidence_container() {
		return (EvidenceContainer) get(Assurance.KEY_EVIDENCE_CONTAINER);
	}
	
	@Override
	public void setEvidence_container(EvidenceContainer value) {
		set(Assurance.KEY_EVIDENCE_CONTAINER, value);
	}
	
	@Override
	public String getGid() {
		return get(Assurance.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Assurance.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Assurance.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
