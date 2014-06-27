package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ClaimEvidenceRelationImpl extends ManagedObjectImpl implements ClaimEvidenceRelation, AssertionRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ClaimEvidenceRelationImpl() {
		super(LMFContext.typeForName(ClaimEvidenceRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ClaimEvidenceRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ClaimEvidenceRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ClaimEvidenceRelation.KEY_ID, value);
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(ClaimEvidenceRelation.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(ClaimEvidenceRelation.KEY_OBJECTIVE, value);
	}
	
	@Override
	public String getDescription() {
		return get(ClaimEvidenceRelation.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(ClaimEvidenceRelation.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(ClaimEvidenceRelation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ClaimEvidenceRelation.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ClaimEvidenceRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ClaimEvidenceRelation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ClaimEvidenceRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(ClaimEvidenceRelation.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(ClaimEvidenceRelation.KEY_TYPE, value);
	}
	
	@Override
	public List<InformationElement> getEvidences() {
		return get(ClaimEvidenceRelation.KEY_EVIDENCES).listContent().toGenericList(InformationElement.class);
	}
	
}
