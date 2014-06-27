package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ClaimsRelationImpl extends ManagedObjectImpl implements ClaimsRelation, AssertionRelation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ClaimsRelationImpl() {
		super(LMFContext.typeForName(ClaimsRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ClaimsRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ClaimsRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ClaimsRelation.KEY_ID, value);
	}
	
	@Override
	public Claim getObjective() {
		return (Claim) get(ClaimsRelation.KEY_OBJECTIVE);
	}
	
	@Override
	public void setObjective(Claim value) {
		set(ClaimsRelation.KEY_OBJECTIVE, value);
	}
	
	@Override
	public List<Claim> getSub_claims() {
		return get(ClaimsRelation.KEY_SUB_CLAIMS).listContent().toGenericList(Claim.class);
	}
	
	@Override
	public String getDescription() {
		return get(ClaimsRelation.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(ClaimsRelation.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(ClaimsRelation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ClaimsRelation.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ClaimsRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ClaimsRelation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ClaimsRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(ClaimsRelation.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(ClaimsRelation.KEY_TYPE, value);
	}
	
}
